import java.security.GeneralSecurityException;
import java.security.cert.*;
import java.util.HashSet;
import java.util.Set;

public class Temp2094 {
    public static void main(String[] args) {
        // Example usage of verifyCertificateChain method
        // You need to replace the below with actual certificates and trust anchors
        Set<X509Certificate> trustedRootCerts = new HashSet<>();
        Set<X509Certificate> intermediateCerts = new HashSet<>();
        X509Certificate cert = null; // replace with actual certificate

        try {
            PKIXCertPathBuilderResult result = verifyCertificateChain(cert, trustedRootCerts, intermediateCerts);
            System.out.println("Certificate chain verified successfully");
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    public static PKIXCertPathBuilderResult verifyCertificateChain(
            X509Certificate cert,
            Set<X509Certificate> trustedRootCerts,
            Set<X509Certificate> intermediateCerts) throws GeneralSecurityException {

        // Create the selector that specifies the starting certificate
        X509CertSelector selector = new X509CertSelector();
        selector.setCertificate(cert);

        // Create the trust anchors (set of root CA certificates)
        Set<TrustAnchor> trustAnchors = new HashSet<>();
        for (X509Certificate trustedRootCert : trustedRootCerts) {
            trustAnchors.add(new TrustAnchor(trustedRootCert, null));
        }

        // Configure the PKIX certificate builder algorithm parameters
        PKIXBuilderParameters pkixParams = new PKIXBuilderParameters(trustAnchors, selector);

        // Disable CRL checks (this is done manually as additional step)
        pkixParams.setRevocationEnabled(false);

        // Specify a list of intermediate certificates
        // certificate itself has to be added to the list
        intermediateCerts.add(cert);
        CertStore intermediateCertStore = CertStore.getInstance("Collection",
                new CollectionCertStoreParameters(intermediateCerts));
        pkixParams.addCertStore(intermediateCertStore);

        // Build and verify the certification chain
        CertPathBuilder builder = CertPathBuilder.getInstance("PKIX");
        PKIXCertPathBuilderResult result = (PKIXCertPathBuilderResult) builder.build(pkixParams);
        return result;
    }
}