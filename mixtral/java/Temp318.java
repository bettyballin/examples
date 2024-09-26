import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Temp318 {
    public static void main(String[] args) {
        try (FileInputStream fis = (FileInputStream) openReading("path/to/your/local/file.txt")) {
            // Read the contents of your local file
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            System.err.println("Error reading from input stream: " + e);
        }
    }

    public static InputStream openReading(String filePath) throws FileNotFoundException {
        return new FileInputStream(filePath);
    }
}