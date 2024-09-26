import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

public class Main {
    public static boolean isReadOnly(Path path) {
        try {
            DosFileAttributes attrs = Files.readAttributes(path, DosFileAttributes.class);
            return attrs.isReadOnly();
        } catch (IOException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Path filePath = Paths.get("example.txt");
        System.out.println("Is read-only: " + isReadOnly(filePath));
    }
}