import java.security.cert.CertificateFactory;
import java.security.cert.CertPath;
import java.security.cert.X509Certificate;
import java.util.List;

public class CertificateChainExample {
    public static void main(String[] args) {
        try {
            // Obtain a CertificateFactory for creating CertPath instances
            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");

            // Create a CertPath object with the certificate chain
            // Assuming 'chain' is properly initialized with your certificate chain
            List<X509Certificate> chain = null; // Replace null with your certificate chain
            CertPath certPath = certFactory.generateCertPath(chain);
            
            // Use the CertPath object as needed
            // ...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}