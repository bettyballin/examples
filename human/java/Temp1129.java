import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;

public class Temp1129 {
    public static void main(String[] args) {
        try {
            File file = new File("/path/to/file");
            InputStream in = new FileInputStream(file);
            byte[] bytes = IOUtils.toByteArray(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}