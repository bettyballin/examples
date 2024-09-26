import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class FileReadExample1 {
    public static void main(String[] args) {
        String filepath = ""; // the full path from System.in
        try {
            byte[] content = Files.readAllBytes(Paths.get(filepath));
            // Use the content byte array as needed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}