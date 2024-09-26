import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class KeyFileReader {
    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources/com/yourcompany/yourproject/keys/KeyFile.txt");
        try {
            String content = Files.readString(path);
            System.out.println("Key File Content:\n" + content);
        } catch (IOException e) {
            System.err.println("Failed to read the key file: " + e.getMessage());
        }
    }
}