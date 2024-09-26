import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class CSRGenerationExample {
    public static void main(String[] args) {
        try {
            KeyPair pair = generateKeyPair();
            PKCS10CertificationRequestBuilder p10Builder = new PKCS10CertificationRequestBuilder(
                new X500Name("CN=Requested Test Certificate"), SubjectPublicKeyInfo.getInstance(pair.getPublic().getEncoded()));
            JcaContentSignerBuilder csBuilder = new JcaContentSignerBuilder("SHA256withRSA");
            ContentSigner signer = csBuilder.build(pair.getPrivate());
            PKCS10CertificationRequest csr = p10Builder.build(signer);
            // Use the CSR (csr) as needed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048, new SecureRandom());
        return keyPairGenerator.generateKeyPair();
    }
}