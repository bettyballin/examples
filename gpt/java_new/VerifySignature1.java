import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.SignerInformationStore;
import org.bouncycastle.cert.jcajce.JcaCertStore;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;
import org.bouncycastle.util.Store;
import org.bouncycastle.util.encoders.Base64;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;

public class VerifySignature1 {
    public static void main(String[] args) throws Exception {
        String signedDataAsString = "base64-encoded-signed-data";
        byte[] signedDataBytes = Base64.decode(signedDataAsString);

        CMSSignedData signedData = new CMSSignedData(signedDataBytes);

        Store<X509Certificate> certStore = signedData.getCertificates();
        SignerInformationStore signerStore = signedData.getSignerInfos();
        Collection<SignerInformation> signers = signerStore.getSigners();
        for (SignerInformation signer : signers) {
            Collection<X509Certificate> certCollection = certStore.getMatches(signer.getSID());
            X509Certificate cert = new JcaX509CertificateConverter().setProvider("BC").getCertificate(certCollection.iterator().next());

            if (signer.verify(new JcaSimpleSignerInfoVerifierBuilder()
                    .setProvider("BC")
                    .build(cert))) {
                System.out.println("Signature verified");
            } else {
                System.out.println("Signature verification failed");
            }
        }
    }
}