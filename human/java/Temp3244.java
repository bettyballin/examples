import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;

public class Temp3244 {
    public static void main(String[] args) {
        try {
            Path clientKeyStore = Paths.get("path/to/keystore");
            char[] password = "password".toCharArray();

            KeyStore keyStore = KeyStore.getInstance("pkcs12");
            keyStore.load(java.nio.file.Files.newInputStream(clientKeyStore), password);

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, password);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

            // You can now use the SSLContext for your TLS connections
            System.out.println("SSLContext successfully created.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}