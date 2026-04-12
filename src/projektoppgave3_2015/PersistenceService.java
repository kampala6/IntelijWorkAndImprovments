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

    public PersistenceService(String var1, String var2) {
        this.textSnapshotPath = Path.of(var1);
        this.serializedPath = Path.of(var2);
    }

    public void save(Lister var1, String var2) throws IOException {
        try (ObjectOutputStream var3 = new ObjectOutputStream(new FileOutputStream(this.serializedPath.toFile()))) {
            var3.writeObject(var1);
        }

        Files.writeString(this.textSnapshotPath, var2);
    }

    public Lister load() throws IOException, ClassNotFoundException {
        if (Files.exists(this.serializedPath, new LinkOption[0])) {
            try (ObjectInputStream var8 = new ObjectInputStream(new FileInputStream(this.serializedPath.toFile()))) {
                return (Lister)var8.readObject();
            }
        } else {
            try (ObjectInputStream var1 = new ObjectInputStream(new FileInputStream(this.textSnapshotPath.toFile()))) {
                return (Lister)var1.readObject();
            }
        }
    }

    public String readTextSnapshot() throws IOException {
        return Files.readString(this.textSnapshotPath);
    }

    public void writeTextSnapshot(String var1) throws IOException {
        Files.writeString(this.textSnapshotPath, var1);
    }

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
