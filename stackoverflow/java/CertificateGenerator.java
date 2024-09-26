import org.bouncycastle.cert.X509CertificateHolder;
import java.security.cert.X509Certificate;

public class CertificateGenerator {
    private CertificateGeneratorUtility generator;
    private X509Certificate serverCertificate;

    public void addServerCertificate() throws Exception {
        generator.addCertificate(new X509CertificateHolder(serverCertificate.getEncoded()));
    }
}

class CertificateGeneratorUtility {
    public void addCertificate(X509CertificateHolder certificateHolder) {
        // Implementation not shown
    }
}