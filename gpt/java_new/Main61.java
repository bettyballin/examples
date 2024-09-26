import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main61 {
    public static void main(String[] args) {
        try {
            FileOutputStream out = new FileOutputStream(new File(Constants.JKS_PRIVATE_FILE_NAME));
            // Use the FileOutputStream 'out' here
            
            // Don't forget to close the FileOutputStream
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Constants {
    public static final String JKS_PRIVATE_FILE_NAME = "path/to/your/file.jks";
}