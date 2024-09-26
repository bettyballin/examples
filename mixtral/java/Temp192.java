import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.Attribute;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;

public class Temp192 {
    public static void main(String[] args) {
        try {
            Security.addProvider(new BouncyCastleProvider());

            // Generate a key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair pair = keyGen.generateKeyPair();

            PublicKey publicKey = pair.getPublic();
            PrivateKey privateKey = pair.getPrivate();

            // Define the subject DN
            X500Name subjectDN = new X500Name("CN=Test, O=Organization, L=City, ST=State, C=Country");

            // Create the content signer
            ContentSigner signer = new JcaContentSignerBuilder("SHA256withRSA").build(privateKey);

            // Create the certificate request
            PKCS10CertificationRequest request = new JcaPKCS10CertificationRequestBuilder(subjectDN, publicKey)
                    .build(signer);

            // Print the request
            System.out.println(request);

            // Or if you have additional attributes:
            Attribute[] attrs = new Attribute[]{}; // Add your attributes here

            PKCS10CertificationRequest requestWithAttributes = new JcaPKCS10CertificationRequestBuilder(subjectDN, publicKey)
                    .build(signer)
                    .setAttributes(attrs);

            // Print the request with attributes
            System.out.println(requestWithAttributes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}