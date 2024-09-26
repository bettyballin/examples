import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Temp2275 {
    private static final String JKS_PRIVATE_FILE_NAME = "private.jks";

    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream(new File(JKS_PRIVATE_FILE_NAME), true)) {
            // Your code to write to the file goes here
            System.out.println("File output stream created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}