//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package projektoppgave3_2015;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

public final class PersistenceService {
    private final Path textSnapshotPath;
    private final Path serializedPath;

    /**
     * Creates a persistence service using the provided text and serialized file paths.
     *
     * @param var1 path to the text snapshot file
     * @param var2 path to the serialized data file
     */
    public PersistenceService(String var1, String var2) {
        this.textSnapshotPath = Path.of(var1);
        this.serializedPath = Path.of(var2);
    }

    /**
     * Saves registry data both as a serialized object and as a text snapshot.
     *
     * @param var1 registry data to save
     * @param var2 text snapshot content
     * @throws IOException if writing either file fails
     */
    public void save(Lister var1, String var2) throws IOException {
        try (ObjectOutputStream var3 = new ObjectOutputStream(new FileOutputStream(this.serializedPath.toFile()))) {
            var3.writeObject(var1);
        }

        Files.writeString(this.textSnapshotPath, var2);
    }

    /**
     * Loads the serialized registry data when available.
     *
     * @return the loaded registry, or a new empty registry when no serialized file exists
     * @throws IOException if the file cannot be read
     * @throws ClassNotFoundException if serialized classes cannot be resolved
     */
    public Lister load() throws IOException, ClassNotFoundException {
        if (Files.exists(this.serializedPath, new LinkOption[0])) {
            try (ObjectInputStream var8 = new ObjectInputStream(new FileInputStream(this.serializedPath.toFile()))) {
                return (Lister)var8.readObject();
            }
        } else {
            return new Lister();
        }
    }

    /**
     * Indicates whether either serialized data or a non-empty text snapshot exists.
     *
     * @return {@code true} if persisted data is available
     */
    public boolean hasPersistedData() {
        if (Files.exists(this.serializedPath, new LinkOption[0])) {
            return true;
        }

        if (!Files.exists(this.textSnapshotPath, new LinkOption[0])) {
            return false;
        }

        try {
            return !Files.readString(this.textSnapshotPath).trim().isEmpty();
        } catch (IOException var2) {
            return true;
        }
    }

    /**
     * Reads the text snapshot file.
     *
     * @return the text snapshot contents
     * @throws IOException if the file cannot be read
     */
    public String readTextSnapshot() throws IOException {
        return Files.readString(this.textSnapshotPath);
    }

    /**
     * Writes the text snapshot file.
     *
     * @param var1 text snapshot content
     * @throws IOException if the file cannot be written
     */
    public void writeTextSnapshot(String var1) throws IOException {
        Files.writeString(this.textSnapshotPath, var1);
    }

    /**
     * Checks whether a text snapshot appears to contain binary control characters.
     *
     * @param var1 text to inspect
     * @return {@code true} if binary control characters are detected
     */
    public boolean containsBinaryCharacters(String var1) {
        for(int var2 = 0; var2 < var1.length(); ++var2) {
            char var3 = var1.charAt(var2);
            if (Character.isISOControl(var3) && var3 != '\n' && var3 != '\r' && var3 != '\t') {
                return true;
            }
        }

        return false;
    }
}
