import java.io.FileInputStream;
import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Main {
    public static void main(String[] args) {
        try {
            InputStream caCertStream = new FileInputStream("src/main/resources/cacert.crt");
            CertificateFactory certFact = CertificateFactory.getInstance("X.509");
            X509Certificate caCertificate = (X509Certificate) certFact.generateCertificate(caCertStream);
            System.out.println("Certificate: " + caCertificate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}