import org.bouncycastle.cert.jcajce.JcaCertStore;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.CMSSignedDataParser;
import org.bouncycastle.cms.jcajce.JcaDigestCalculatorProviderBuilder;
import org.bouncycastle.cms.jcajce.JcaSignerInfoVerifierBuilder;
import org.bouncycastle.operator.jcajce.JcaContentVerifierProviderBuilder;
import org.bouncycastle.util.Store;

import java.io.ByteArrayInputStream;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Collection;

public class Temp211 {
    public static void main(String[] args) {
        try {
            // Add BouncyCastle Provider
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

            byte[] derEncodedSignature = new byte[0]; // Add your DER encoded signature bytes here

            CMSSignedDataParser sp = new CMSSignedDataParser(
                    new JcaDigestCalculatorProviderBuilder().setProvider("BC").build(),
                    new ByteArrayInputStream(derEncodedSignature)
            );

            sp.getSignedContent().drain();

            Store<X509Certificate> certStore = sp.getCertificates();
            Collection<X509Certificate> certs = certStore.getMatches(null);

            for (X509Certificate cert : certs) {
                sp.getSignerInfos().getSigners().forEach(signer -> {
                    try {
                        if (signer.verify(new JcaSignerInfoVerifierBuilder(
                                new JcaDigestCalculatorProviderBuilder().setProvider("BC").build())
                                .setProvider("BC")
                                .build(new JcaContentVerifierProviderBuilder().setProvider("BC").build(cert)))) {
                            System.out.println("Signature verified");
                        } else {
                            System.out.println("Signature verification failed");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}