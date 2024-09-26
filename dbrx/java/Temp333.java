import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class Temp333 {
    public static void main(String[] args) {
        try {
            // Initialize a KeyStore with the default type
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);

            // Load the certificate from a resource file (replace with the correct resource ID or file path)
            InputStream is = Temp333.class.getResourceAsStream("/path/to/your/certificate.pem");
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            Certificate cert = cf.generateCertificate(is);
            is.close();

            // Add the certificate to the KeyStore
            keyStore.setCertificateEntry("godaddy-intermediate", cert);

            // Initialize a TrustManagerFactory with the KeyStore
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(keyStore);

            // Initialize an SSLContext with the TrustManagers from the TrustManagerFactory
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);

            // Use the custom SSLContext for your HTTPS connections
            // Example: HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

            System.out.println("Custom SSLContext has been set up successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}