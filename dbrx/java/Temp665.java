import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\example.txt");
        
        if (!isReadOnly(path)) {
            System.out.println("File does not have read-only attribute set.");
            
            if (Files.isWritable(path)) {
                System.out.println("You can write into the file.");
            } else {
                System.out.println("You cannot modify or create a new file due to Access Control Lists permissions.");
            }
        }
    }

    public static boolean isReadOnly(Path path) {
        try {
            return (path.toFile().canRead() && !path.toFile().canWrite());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}