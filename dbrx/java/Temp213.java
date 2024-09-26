import java.security.cert.*;
import java.util.*;

public class Temp213 {
    public static void main(String[] args) {
        try {
            // Sample list of certificates for demonstration purposes
            List<X509Certificate> certs = new ArrayList<>();
            // Add certificates to the list

            // Sample trust anchors for demonstration purposes
            Set<TrustAnchor> trustAnchors = new HashSet<>();
            // Add trust anchors to the set

            for (X509Certificate cert : certs) {
                try {
                    // check if it's self-signed which means we've reached a trusted anchor/root CA
                    boolean isSelfSigned = cert.getSubjectDN().equals(cert.getIssuerDN());

                    CertPathValidator validator = CertPathValidator.getInstance("PKIX", "BC");
                    PKIXParameters params = new PKIXParameters(trustAnchors);
                    params.setRevocationEnabled(false); // disable CRL checking for simplicity

                    if (!isSelfSigned) {
                        List<X509Certificate> certList = Arrays.asList(cert, certs.get(certs.size() - 1));
                        CertificateFactory cf = CertificateFactory.getInstance("X.509");
                        CertPath certPath = cf.generateCertPath(certList);
                        validator.validate(certPath, params);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}