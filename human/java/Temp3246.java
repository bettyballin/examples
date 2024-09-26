import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Temp3246 {
    public static void main(String[] args) {
        Path pemPath = Paths.get("path/to/your/certificate.pem");
        try (InputStream is = Files.newInputStream(pemPath)) {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) certificateFactory.generateCertificate(is);
            String alias = cert.getSubjectX500Principal().getName();
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            keyStore.setCertificateEntry(alias, cert);
            System.out.println("Certificate added to keystore with alias: " + alias);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}