import java.util.Date;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.io.InputStream;
import java.io.FileInputStream;
import java.security.cert.X509Certificate;

public class Temp210 {
    public static void main(String[] args) {
        try {
            InputStream signingCertStream = new FileInputStream("path/to/signingCertificate.crt");
            InputStream rootCACertStream = new FileInputStream("path/to/rootCACertificate.crt");
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            
            X509Certificate signingCertificate = (X509Certificate) cf.generateCertificate(signingCertStream);
            X509Certificate rootCACertificate = (X509Certificate) cf.generateCertificate(rootCACertStream);
            
            Date now = new Date();
            assert !signingCertificate.getNotAfter().before(now) : "Signing certificate is expired.";
            assert !rootCACertificate.getNotBefore().after(now) : "Root CA certificate is not yet valid.";
            
            // Repeat for all intermediate CAs
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}