import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class Temp2276 {

    private static final String JKS_PRIVATE_FILE_NAME = "private.jks";

    public static void main(String[] args) {
        try {
            FileOutputStream out = new FileOutputStream(getFile2(JKS_PRIVATE_FILE_NAME));
            // Add your file writing logic here
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File getFile2(String fileName) {
        return new File(fileName);
    }
}