import java.security.cert.*;
import java.security.cert.CertificateFactory;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidator;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.util.*;

import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaCertStore;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp212 {
    public static void main(String[] args) throws Exception {
        // Add BouncyCastle as a security provider
        Security.addProvider(new BouncyCastleProvider());

        // Placeholder for the root certificate
        X509CertificateHolder certRootHolder = null; // Replace with actual root certificate retrieval
        JcaX509CertificateConverter converter = new JcaX509CertificateConverter().setProvider("BC");
        X509Certificate certRoot = converter.getCertificate(certRootHolder);

        // Placeholder for retrieving the SignerInformation from your source
        // This would be the collection of certificates you are working with
        List<X509Certificate> certificates = new ArrayList<>(); // Replace with actual certificates
        JcaCertStore store = new JcaCertStore(certificates);

        // Retrieve the collection of certificates
        // Adapt this line to your actual method of finding certificates
        Collection<X509Certificate> certs = store.getCertificates(null);

        for (X509Certificate cert : certs) {
            if (!cert.equals(certRoot)) { // check for the root certificate
                continue;
            }

            Set<TrustAnchor> trustAnchors = new HashSet<>();
            trustAnchors.add(new TrustAnchor(cert, null));

            CertPathValidator validator = CertPathValidator.getInstance("PKIX", "BC");
            PKIXParameters params = new PKIXParameters(trustAnchors);
            params.setRevocationEnabled(false); // disable CRL checking for simplicity

            try {
                List<X509Certificate> certList = Arrays.asList(cert);
                CertificateFactory cf = CertificateFactory.getInstance("X.509");
                CertPath cp = cf.generateCertPath(certList);

                validator.validate(cp, params);
                System.out.println("Root certificate is trusted.");
            } catch (Exception e) {
                System.err.println("Error validating root certificate: " + e.getMessage());
            }
        }
    }
}