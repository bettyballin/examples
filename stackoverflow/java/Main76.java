import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main76 {
    private static final String JKS_PRIVATE_FILE_NAME = "private.jks";

    public static void main(String[] args) {
        try {
            FileOutputStream out = new FileOutputStream(new File(JKS_PRIVATE_FILE_NAME), true);
            // Perform operations with FileOutputStream 'out'
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}