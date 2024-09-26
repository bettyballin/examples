import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileToByteArray {
    public static void main(String[] args) throws IOException {
        // Replace "/path/to/file" with the actual path to your file
        String filePath = "/path/to/file";
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        
        System.out.println("File size in bytes: " + bytes.length);
    }
}