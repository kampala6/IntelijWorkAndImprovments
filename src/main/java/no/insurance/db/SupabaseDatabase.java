package no.insurance.db;

import no.insurance.model.*;
import no.insurance.service.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class SupabaseDatabase {
    private static final int CONNECT_TIMEOUT_MS = 5000;
    private static final int READ_TIMEOUT_MS = 5000;
    private static final String DEFAULT_PORT = "5432";
    private static final String DEFAULT_DB_NAME = "postgres";
    private static final Map<String, String> ENV_FILE_VALUES = loadEnvFile();
    private static volatile String lastEnvFilePath = "not found";
    private static volatile String lastConnectionDiagnostic = "Not tested yet.";

    private SupabaseDatabase() {
    }

    public static Connection getConnection() throws SQLException {
        ensureDriverLoaded();
        String dbUrl = resolveJdbcUrl();
        String user = requireEnv("SUPABASE_DB_USER");
        String password = requireEnv("SUPABASE_DB_PASSWORD");
        return DriverManager.getConnection(dbUrl, user, password);
    }

    public static boolean testConnection() {
        try (Connection connection = getConnection()) {
            // PgBouncer/pooler setups can report isValid(false) even when simple queries work.
            try (Statement statement = connection.createStatement()) {
                statement.execute("SELECT 1");
                lastConnectionDiagnostic = "DB OK via JDBC. .env source: " + lastEnvFilePath;
                return true;
            }
        } catch (SQLException | IllegalStateException exception) {
            boolean restOk = testRestApiConnection();
            if (!restOk) {
                lastConnectionDiagnostic = "DB failed: " + exception.getMessage() + " | .env source: " + lastEnvFilePath;
            }
            return restOk;
        }
    }

    public static String getLastConnectionDiagnostic() {
        return lastConnectionDiagnostic;
    }

    private static void ensureDriverLoaded() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException exception) {
            throw new IllegalStateException("PostgreSQL driver not found on classpath (lib/postgresql.jar)", exception);
        }
    }

    private static String resolveJdbcUrl() {
        String explicitUrl = getEnvOrDefault("SUPABASE_DB_URL", null);
        if (!isBlank(explicitUrl)) {
            return normalizeJdbcUrl(explicitUrl);
        }

        String host = requireEnv("SUPABASE_DB_HOST");
        String port = getEnvOrDefault("SUPABASE_DB_PORT", DEFAULT_PORT);
        String dbName = getEnvOrDefault("SUPABASE_DB_NAME", DEFAULT_DB_NAME);
        return normalizeJdbcUrl("jdbc:postgresql://" + host + ":" + port + "/" + dbName + "?sslmode=require");
    }

    private static String normalizeJdbcUrl(String url) {
        String normalized = url.trim();
        String lower = normalized.toLowerCase();
        if (!lower.contains("preferquerymode=")) {
            normalized = normalized + (normalized.contains("?") ? "&" : "?") + "preferQueryMode=simple";
        }
        return normalized;
    }

    private static boolean testRestApiConnection() {
        String baseUrl = getEnvOrDefault("NEXT_PUBLIC_SUPABASE_URL", null);
        String publishableKey = getEnvOrDefault("NEXT_PUBLIC_SUPABASE_PUBLISHABLE_KEY", null);

        if (isBlank(baseUrl) || isBlank(publishableKey)) {
            System.err.println("Could not connect to Supabase.");
            System.err.println("Provide DB credentials (SUPABASE_DB_*) or REST credentials (NEXT_PUBLIC_SUPABASE_*).");
            return false;
        }

        HttpURLConnection connection = null;
        try {
            String normalized = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
            URL url = new URL(normalized + "/rest/v1/");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("apikey", publishableKey);
            connection.setRequestProperty("Authorization", "Bearer " + publishableKey);
            connection.setConnectTimeout(CONNECT_TIMEOUT_MS);
            connection.setReadTimeout(READ_TIMEOUT_MS);

            int code = connection.getResponseCode();
            if (code >= 200 && code < 400) {
                lastConnectionDiagnostic = "REST OK (HTTP " + code + "). .env source: " + lastEnvFilePath;
                return true;
            }

            System.err.println("Supabase REST API check returned HTTP " + code + ".");
            lastConnectionDiagnostic = "REST failed (HTTP " + code + "). .env source: " + lastEnvFilePath;
            return false;
        } catch (IOException ioException) {
            System.err.println("Supabase REST API check failed: " + ioException.getMessage());
            lastConnectionDiagnostic = "REST failed: " + ioException.getMessage() + " | .env source: " + lastEnvFilePath;
            return false;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private static String requireEnv(String key) {
        String value = getEnvValue(key);
        if (isBlank(value)) {
            throw new IllegalStateException("Missing environment variable: " + key);
        }
        return value.trim();
    }

    private static String getEnvOrDefault(String key, String defaultValue) {
        String value = getEnvValue(key);
        if (isBlank(value)) {
            return defaultValue;
        }
        return value.trim();
    }

    private static String getEnvValue(String key) {
        String runtimeValue = System.getenv(key);
        if (!isBlank(runtimeValue)) {
            return runtimeValue;
        }
        return ENV_FILE_VALUES.get(key);
    }

    private static Map<String, String> loadEnvFile() {
        Map<String, String> values = new HashMap<String, String>();
        Path envPath = resolveEnvFilePath();
        if (envPath == null || !Files.exists(envPath)) {
            lastEnvFilePath = "not found";
            return values;
        }

        lastEnvFilePath = envPath.toString();

        try (BufferedReader reader = Files.newBufferedReader(envPath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmed = line.trim();
                if (trimmed.isEmpty() || trimmed.startsWith("#")) {
                    continue;
                }

                int equalsIndex = trimmed.indexOf('=');
                if (equalsIndex <= 0) {
                    continue;
                }

                String key = trimmed.substring(0, equalsIndex).trim();
                String rawValue = trimmed.substring(equalsIndex + 1).trim();
                if (rawValue.length() >= 2
                        && ((rawValue.startsWith("\"") && rawValue.endsWith("\""))
                        || (rawValue.startsWith("'") && rawValue.endsWith("'")))) {
                    rawValue = rawValue.substring(1, rawValue.length() - 1);
                }

                if (!isBlank(key) && !isBlank(rawValue)) {
                    values.put(key, rawValue);
                }
            }
        } catch (IOException exception) {
            System.err.println("Warning: could not read .env.local: " + exception.getMessage());
        }
        return values;
    }

    private static Path resolveEnvFilePath() {
        String explicitEnvPath = System.getenv("SUPABASE_ENV_FILE");
        if (!isBlank(explicitEnvPath)) {
            Path explicitPath = Paths.get(explicitEnvPath).toAbsolutePath().normalize();
            if (Files.exists(explicitPath)) {
                return explicitPath;
            }
        }

        Set<Path> seedPaths = new LinkedHashSet<Path>();
        seedPaths.add(Paths.get(System.getProperty("user.dir")).toAbsolutePath().normalize());

        try {
            URL codeSourceUrl = SupabaseDatabase.class.getProtectionDomain().getCodeSource().getLocation();
            Path codeSourcePath = Paths.get(codeSourceUrl.toURI()).toAbsolutePath().normalize();
            if (Files.isRegularFile(codeSourcePath)) {
                codeSourcePath = codeSourcePath.getParent();
            }
            if (codeSourcePath != null) {
                seedPaths.add(codeSourcePath);
            }
        } catch (RuntimeException | URISyntaxException ignored) {
        }

        List<Path> candidates = new ArrayList<Path>();
        for (Path seed : seedPaths) {
            Path current = seed;
            while (current != null) {
                candidates.add(current.resolve(".env.local"));
                candidates.add(current.resolve(".env"));
                current = current.getParent();
            }
        }

        // Last-resort fallback for IDE launches with unusual working directories.
        Path homeEnvLocal = Paths.get(System.getProperty("user.home"), ".env.local").toAbsolutePath().normalize();
        candidates.add(homeEnvLocal);
        Path homeEnv = Paths.get(System.getProperty("user.home"), ".env").toAbsolutePath().normalize();
        candidates.add(homeEnv);

        for (Path candidate : candidates) {
            if (Files.exists(candidate)) {
                return candidate;
            }
        }
        return null;
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}