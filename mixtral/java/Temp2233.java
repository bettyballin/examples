import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Temp2233 {
    public static void main(String[] args) {
        try {
            byte[] encryptedMessageWithIV = Files.readAllBytes(Paths.get("path/to/your/file"));
            // Process the byte array as needed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}