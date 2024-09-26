import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributes;

public class FileUtilities {

    private boolean isReadOnlyFile(Path file) {
        if (System.getProperty("os.name").startsWith("Windows")) {
            try {
                DosFileAttributes dosAttr = Files.readAttributes(file, DosFileAttributes.class);
                return !file.toFile().canWrite() || dosAttr.isReadOnly();
            } catch (IOException ignored) {
                // Exception ignored for brevity
            }
        }
        return false;
    }
}