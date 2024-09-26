import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.CertPathBuilder;
import java.security.cert.PKIXParameters;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

public class Temp19 {
    public static void main(String[] args) {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("/path/to/keystore"), "password".toCharArray());

            PKIXParameters params = new PKIXParameters(keyStore);
            params.setRevocationEnabled(false);

            CertPathBuilder builder = CertPathBuilder.getInstance("PKIX");
            List<X509Certificate> certificates = Arrays.asList((X509Certificate[]) keyStore.getCertificateChain("cert_alias"));

            X509CertSelector selector = new X509CertSelector();
            selector.setCertificate(certificates.get(0));
            builder.build(new CertPathBuilder.CertPathParameters() {
                @Override
                public CertPathBuilder getProvider() {
                    return builder;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}