import java.io.FileInputStream;
import java.security.KeyStore;
import javax.net.ssl.*;

public class Temp685 {
    public static void main(String[] args) {
        try {
            // Set the trustStore properties
            System.setProperty("javax.net.ssl.trustStore", "/path/to/server.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", "password");

            // Load the trustStore
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            FileInputStream trustStoreStream = new FileInputStream("/path/to/server.jks");
            trustStore.load(trustStoreStream, "password".toCharArray());

            // Initialize a TrustManagerFactory with the trustStore
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(trustStore);

            // Get the TrustManagers
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();

            // Initialize an SSLContext with the TrustManagers
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagers, null);

            // Set the default SSLContext
            SSLContext.setDefault(sslContext);

            System.out.println("TrustStore is set successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}