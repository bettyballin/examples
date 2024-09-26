import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.Collections;

public class Temp293 {
    public static void main(String[] args) {
        try {
            // Path to file you want to create and set as read-only
            Path file = Paths.get("example.txt");

            // Create a new file
            Files.createFile(file);

            // Set the read-only attribute on the file
            Files.setPosixFilePermissions(file, PosixFilePermissions.fromString("r--r--r--"));

            System.out.println("File created and set to read-only: " + file.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}