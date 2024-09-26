import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Temp664 {
    public static void main(String[] args) {
        Path path = Paths.get("example.txt");
        try {
            System.out.println("Is writable: " + isWritable(path));
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static boolean isWritable(Path path) throws IOException {
        return Files.isWritable(path);
    }
}