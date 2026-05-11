package projektoppgave3_2015;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Verifies that all expected schema tables exist in Supabase/Postgres.
 */
public final class SupabaseSchemaSmokeTest {
    private static final String[] REQUIRED_TABLES = new String[] {
            "adresse",
            "kunde",
            "kunde_sequence_state",
            "forsikring",
            "bilforsikring",
            "baatforsikring",
            "husoginnboforsikring",
            "fritidsbolig_forsikiring",
            "reise",
            "skade_melding"
    };

    private SupabaseSchemaSmokeTest() {
    }

    public static void main(String[] args) {
        try {
            boolean allExist = verifyTables();
            if (allExist) {
                System.out.println("Schema smoke test passed: all required tables exist.");
            } else {
                System.out.println("Schema smoke test failed: one or more required tables are missing.");
            }
        } catch (SQLException exception) {
            System.err.println("Schema smoke test failed due to database error: " + exception.getMessage());
            exception.printStackTrace();
        }
    }

    public static boolean verifyTables() throws SQLException {
        boolean allExist = true;
        try (Connection connection = SupabaseDatabase.getConnection();
             Statement statement = connection.createStatement()) {
            for (String table : REQUIRED_TABLES) {
                String qualifiedTable = "public." + table;
                String query = "SELECT to_regclass('" + qualifiedTable + "')";
                try (ResultSet resultSet = statement.executeQuery(query)) {
                    String resolvedName = null;
                    if (resultSet.next()) {
                        resolvedName = resultSet.getString(1);
                    }

                    boolean exists = resolvedName != null && !resolvedName.trim().isEmpty();
                    System.out.println((exists ? "[OK] " : "[MISSING] ") + table);
                    if (!exists) {
                        allExist = false;
                    }
                }
            }
        }
        return allExist;
    }
}

