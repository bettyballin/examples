import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Temp251 {
    public static void main(String[] args) {
        try {
            File tempFile = File.createTempFile("prefix", ".tmp");
            tempFile.deleteOnExit();

            // Write to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                writer.write("Sample text");
            }

            // Read from the file and process data as necessary
            // For demonstration purposes, let's just print the content
            Files.lines(Paths.get(tempFile.getAbsolutePath())).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}