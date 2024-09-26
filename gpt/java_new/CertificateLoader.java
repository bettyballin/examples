import java.io.FileInputStream;
import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class CertificateLoader {
    public static void main(String[] args) {
        try {
            InputStream inStream = new FileInputStream("path/to/your/certificate.cer");
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);
            inStream.close();
            // Use the certificate as needed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}