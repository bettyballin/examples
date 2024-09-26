import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.cert.jcajce.JcaPKCS10CertificationRequestBuilder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.asn1.x509.ExtensionsGenerator;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public class Temp1626 {
    public static void main(String[] args) {
        try {
            Security.addProvider(new BouncyCastleProvider());

            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA", BouncyCastleProvider.PROVIDER_NAME);
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();

            X500Name subjectDN = new X500Name("CN=Test, O=MyOrg");

            ContentSigner signer = new JcaContentSignerBuilder("SHA256withRSA")
                    .setProvider(BouncyCastleProvider.PROVIDER_NAME)
                    .build(keyPair.getPrivate());

            JcaPKCS10CertificationRequestBuilder csrBuilder =
                    new JcaPKCS10CertificationRequestBuilder(subjectDN, keyPair.getPublic());

            ExtensionsGenerator extGen = new ExtensionsGenerator();
            // Add extensions here
            csrBuilder.addAttribute(PKCSObjectIdentifiers.pkcs_9_at_extensionRequest, extGen.generate());

            PKCS10CertificationRequest csr = csrBuilder.build(signer);

            // EnrollmentResponse resp = eSTService.simpleEnrollPoP(false, csr, null);
            // Perform enrollment with the generated CSR

        } catch (java.security.NoSuchAlgorithmException | 
                 java.security.NoSuchProviderException | 
                 OperatorCreationException | 
                 CertIOException e) {
            e.printStackTrace();
        }
    }
}