import java.io.File;
import java.io.FileReader;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class Temp49 {
    public static void main(String[] args) {
        File inputFile = (File) AccessController.doPrivileged(new PrivilegedAction<File>() {
            public File run() {
                File inputFile1 = new File("C:\\Program Files\\MyFolder\\MyFile.jpg");
                return inputFile1;
            }
        });

        try {
            FileReader in = new FileReader(inputFile);
            // Add any additional logic here as needed
            in.close(); // Close the FileReader
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}