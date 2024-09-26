import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import java.security.KeyStore;
import java.security.cert.X509Certificate;

public class Temp1254 {
    public static void main(String[] args) {
        try {
            // Initialize a TrustManagerFactory with the default KeyStore
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init((KeyStore) null);

            // Get the X509TrustManager from the factory
            X509TrustManager x509Tm = (X509TrustManager) tmf.getTrustManagers()[0];

            // Example certificate chain and authType
            X509Certificate[] certChain = new X509Certificate[]{};
            String authType = "RSA";

            // Call checkServerTrusted on the X509TrustManager
            x509Tm.checkServerTrusted(certChain, authType);

            System.out.println("Server trusted check completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}