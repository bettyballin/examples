import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.cert.*;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXCertPathBuilderResult;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Temp47 {

    public static void main(String[] args) throws Exception {
        // Load CA certificates
        List<X509Certificate> caCerts = new ArrayList<>();
        caCerts.add(loadCert("path/to/issuer_cert"));

        // Create a set of trusted CAs
        Set<TrustAnchor> trustAnchors = new HashSet<>(1);
        trustAnchors.add(new TrustAnchor(caCerts.get(caCerts.size() - 1), null));

        // Create a PKIXParameters object
        PKIXBuilderParameters pkixParams = new PKIXBuilderParameters(trustAnchors, new X509CertSelector());

        // Create a certificate path
        List<X509Certificate> certChain = new ArrayList<>();
        // Add your certificate(s) to certChain
        // e.g., certChain.add(loadCert("path/to/your_cert"));
        certChain.removeAll(caCerts);

        PKIXCertPathBuilderResult result;
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");

            // Build the certificate path
            CertPathBuilder builder = CertPathBuilder.getInstance("PKIX");
            CertPath certPath = cf.generateCertPath(certChain);
            PKIXCertPathBuilderResult buildResult = (PKIXCertPathBuilderResult) builder.build(new CertPathBuilderParameters() {
                @Override
                public CertPathChecker getCertPathChecker() {
                    return null;
                }
            });
            result = buildResult;
            System.out.println("Certificate Path Built Successfully!");
        } catch (CertPathBuilderException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }

    private static X509Certificate loadCert(String path) throws IOException, CertificateException {
        try (FileInputStream fis = new FileInputStream(path)) {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            return (X509Certificate) cf.generateCertificate(fis);
        }
    }
}