import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Certificates {
    public static void main(String[] args) {
        try {
            String pack = "path/to/certificates/";
            String signCertName = "certificateName"; // Replace with your certificate name
            InputStream signCertIn = Certificates.class.getResourceAsStream(pack + signCertName + ".cer");

            if (signCertIn == null) {
                throw new RuntimeException("Certificate not found!");
            }

            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(signCertIn);
            System.out.println("Certificate loaded successfully: " + cert.getSubjectDN());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}