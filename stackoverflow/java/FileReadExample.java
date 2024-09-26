import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReadExample {
    public static void main(String[] args) {
        byte[] filebytea = new byte[1024]; // Assuming file content will fit into this array
        // Replace "path/to/file" with the actual file path
        try (DataInputStream in = new DataInputStream(new FileInputStream("path/to/file"))) {
            in.readFully(filebytea);
        } catch (IOException e) {
            // Log the exception or handle it as required
        }
    }
}