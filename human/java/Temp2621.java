import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class KeyFileReader {
    public static void main(String[] args) {
        Path filePath = Paths.get("src/main/resources/com/yourcompany/yourproject/keys/KeyFile.txt");
        try {
            String content = Files.readString(filePath);
            System.out.println("Key File Content: ");
            System.out.println(content);
        } catch (IOException e) {
            System.err.println("Error reading the key file: " + e.getMessage());
        }
    }
}