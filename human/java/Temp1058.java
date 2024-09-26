import java.io.FileInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Temp1058 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Please provide the certificate file path as an argument.");
            System.exit(1);
        }

        try (FileInputStream is = new FileInputStream(args[0])) {
            CertificateFactory fact = CertificateFactory.getInstance("X.509");
            X509Certificate cer = (X509Certificate) fact.generateCertificate(is);
            PublicKey key = cer.getPublicKey();
            System.out.println("Public Key: " + key);
        } catch (CertificateException | IOException e) {
            e.printStackTrace();
        }
    }
}