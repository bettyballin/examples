import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.io.InputStream;

public class CertificateLoader {
    public static void main(String[] args) {
        try {
            CertificateFactory f = CertificateFactory.getInstance("X.509");
            InputStream is = CertificateLoader.class.getResourceAsStream("/ca.pem");
            if (is == null) {
                System.out.println("Certificate not found");
                return;
            }
            X509Certificate loadedCaCert = (X509Certificate) f.generateCertificate(is);
            System.out.println("Certificate loaded successfully: " + loadedCaCert.getSubjectDN());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}