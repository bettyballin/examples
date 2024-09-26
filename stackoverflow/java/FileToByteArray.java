import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;

public class FileToByteArray {
    public static void main(String[] args) {
        File file = new File("/path/to/file");
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            byte[] bytes = IOUtils.toByteArray(in);
            // Do something with the bytes
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}