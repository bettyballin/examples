import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class Temp1253 {
    public static void main(String[] args) {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);

            X509TrustManager trustManager = (X509TrustManager) trustManagerFactory.getTrustManagers()[0];

            X509Certificate[] certChain = new X509Certificate[] {}; // Provide a valid certificate chain
            String authType = "RSA"; // Provide a valid authentication type

            trustManager.checkServerTrusted(certChain, authType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}