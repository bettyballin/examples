import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import java.io.ByteArrayOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.util.Base64;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp2528 {
    public static void main(String[] args) throws Exception {
        // Add BouncyCastle provider
        Security.addProvider(new BouncyCastleProvider());

        // Generate a key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // Define the subject for the CSR
        X500Name xname = new X500Name("CN=Test Certificate");

        // Create the ContentSigner
        ContentSigner signAlgorithm = new JcaContentSignerBuilder("SHA256withRSA").build(privateKey);

        // Create the CSR
        PKCS10CertificationRequest csr = new JcaPKCS10CertificationRequestBuilder(xname, publicKey)
                .build(signAlgorithm);

        // Serialize the CSR to ASN.1
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ASN1OutputStream aos = ASN1OutputStream.create(baos);
        aos.writeObject(csr.toASN1Structure());
        aos.close();

        // Encode the CSR in Base64
        String sTmp = Base64.getEncoder().encodeToString(baos.toByteArray());
        System.out.println(sTmp);
    }
}