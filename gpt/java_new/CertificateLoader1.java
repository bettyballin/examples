import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.io.FileInputStream;
import java.io.InputStream;

public class CertificateLoader1 {

    public static PublicKey loadPublicKeyFromPEMFile(String certificateFilePath) throws Exception {
        try (InputStream inStream = new FileInputStream(certificateFilePath)) {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);
            return cert.getPublicKey();
        }
    }
}