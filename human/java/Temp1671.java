import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributes;

public class ReadOnlyFileChecker {

    public static void main(String[] args) {
        // Example usage
        Path filePath = Path.of("example.txt");
        ReadOnlyFileChecker checker = new ReadOnlyFileChecker();
        boolean isReadOnly = checker.isReadOnlyFile(filePath);
        System.out.println("Is the file read-only? " + isReadOnly);
    }

    private boolean isReadOnlyFile(Path file) {
        if (isWindows()) {
            if (!file.toFile().canWrite()) {
                DosFileAttributes dosAttr;
                try {
                    dosAttr = Files.readAttributes(file, DosFileAttributes.class);
                    if (dosAttr.isReadOnly()) {
                        return true;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    private boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }
}