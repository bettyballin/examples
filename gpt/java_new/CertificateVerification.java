import java.io.FileInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class CertificateVerification {
    public static void main(String[] args) {
        String pathToCertificate = "path/to/your/certificate.cer";
        String pathToCACertificate = "path/to/your/ca_certificate.cer";

        try (FileInputStream certInputStream = new FileInputStream(pathToCertificate);
             FileInputStream caCertInputStream = new FileInputStream(pathToCACertificate)) {

            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");

            // Load the certificate to verify
            X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(certInputStream);

            // Load the CA certificate
            X509Certificate caCertificate = (X509Certificate) certificateFactory.generateCertificate(caCertInputStream);

            // Verify the certificate
            PublicKey caPublicKey = caCertificate.getPublicKey();
            certificate.verify(caPublicKey);
            System.out.println("Certificate verification succeeded.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Certificate verification failed.");
        }
    }
}