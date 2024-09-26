import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class ReadOnlyCheck {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("C:\\path\\to\\your\\file.txt");

            if (!Files.exists(path)) {
                System.out.println("The file does not exist.");
            } else {
                // Retrieve basic file attributes
                BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);

                // Check if the file is not writable
                if (!Files.isWritable(path)) {
                    System.out.println("The file is read-only.");
                } else {
                    System.out.println("The file is writable.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}