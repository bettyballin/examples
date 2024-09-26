import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class FileToBytes {
    public static void main(String[] args) {
        Path path = Paths.get("path/to/your/file");

        try {
            byte[] data = Files.readAllBytes(path);
            // Now you can use the byte array 'data' for your encryption algorithms.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}