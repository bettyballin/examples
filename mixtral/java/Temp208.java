import java.security.KeyStore;
import java.security.cert.CertPathBuilder;
import java.security.cert.PKIXParameters;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

public class Temp208 {
    public static void main(String[] args) throws Exception {
        // Assuming these certificates are already initialized
        X509Certificate signingCert = null; // TODO: Initialize with actual certificate
        X509Certificate intermediateCA1 = null; // TODO: Initialize with actual certificate
        X509Certificate rootCACert = null; // TODO: Initialize with actual certificate
        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType()); // TODO: Initialize with actual trust store

        List<X509Certificate> certChain = Arrays.asList(signingCert, intermediateCA1, rootCACert);

        CertPathBuilder builder = CertPathBuilder.getInstance("PKIX", "BC");

        PKIXParameters params = new PKIXParameters(trustStore);
        params.setRevocationEnabled(false);

        X509CertSelector selector = new X509CertSelector();
        selector.setCertificate(signingCert);

        builder.build(new CertPathBuilderResultImpl(certChain, params)).getCertPath().getEncoded();
    }
}