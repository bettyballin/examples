import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.*;
import java.util.Collections;

public class CertPathBuilderExample {
    X509Certificate leafCertificate; // your leaf certificate
    Collection<X509Certificate> certificates; // your collection of certificates

    public void buildCertPath() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, CertPathBuilderException {
        CertStore intermediateCertStore = CertStore.getInstance("Collection", new CollectionCertStoreParameters(certificates));

        X509CertSelector selector = new X509CertSelector();
        selector.setCertificate(leafCertificate);

        PKIXBuilderParameters pkixParams = new PKIXBuilderParameters(Collections.singleton(new TrustAnchor((X509Certificate) null, null)), selector);
        pkixParams.addCertStore(intermediateCertStore);

        CertPathBuilder builder = CertPathBuilder.getInstance("PKIX");
        CertPathBuilderResult result = builder.build(pkixParams);
        // Use the result (e.g., validate the certification path)
    }
}