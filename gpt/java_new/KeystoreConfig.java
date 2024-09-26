import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class KeystoreConfig {
    public static void main(String[] args) {
        // Load the properties file
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("keystore.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Set system properties
        System.setProperty("javax.net.ssl.keyStore", props.getProperty("keystoreLocation", "myJks"));
        System.setProperty("javax.net.ssl.keyStorePassword", props.getProperty("keystorePassword"));

        // Rest of your application logic
    }
}