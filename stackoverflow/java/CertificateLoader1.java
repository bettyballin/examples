import java.io.FileInputStream;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class CertificateLoader1 {
    public static void main(String[] args) {
        if (args.length > 0) {
            try (FileInputStream is = new FileInputStream(args[0])) {
                CertificateFactory fact = CertificateFactory.getInstance("X.509");
                X509Certificate cer = (X509Certificate) fact.generateCertificate(is);
                PublicKey key = cer.getPublicKey();
                // Use the public key as needed
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}