import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Temp1668 {
    public static void main(String[] args) {
        check("c:\\foo");
        check("c:\\bar");
    }

    private static void check(String pathString) {
        Path path = Paths.get(pathString);

        if (Files.exists(path)) {
            System.out.println("check " + pathString);

            if (Files.isRegularFile(path)) {
                System.out.println("file      Files.isWritable: " + Files.isWritable(path));
            } else if (Files.isDirectory(path)) {
                System.out.println("directory Files.isWritable: " + Files.isWritable(path));
            }
        } else {
            System.out.println("Path " + pathString + " does not exist.");
        }
    }
}