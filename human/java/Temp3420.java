import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Temp3420 {
    public static void main(String[] args) {
        final Properties properties = new Properties();
        try (final FileInputStream input = new FileInputStream("yourExistingFile")) {
            properties.load(input);
            properties.put("ssl.key.password", System.getenv("SSL_KEY_PASSWORD")); //this is additional property
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}