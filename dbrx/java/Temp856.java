import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;

public class Temp856 {
    public static void main(String[] args) {
        try {
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            InputStream is = new FileInputStream("path/to/your/internal/java/truststore");
            ks.load(is, "password".toCharArray());
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}