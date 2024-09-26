import java.math.BigInteger;
import java.security.*;
import java.security.cert.X509Certificate;
import java.time.Instant;
import java.util.Date;
import sun.security.x509.X500Name;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

public class Temp2150 {
    public static void main(String[] args) throws Exception {
        // Generate a key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        X500Name x500name = new X500Name("CN=localhost");
        ContentSigner signer = new JcaContentSignerBuilder("SHA256withRSA").build(privateKey);

        JcaX509v3CertificateBuilder certGen = new JcaX509v3CertificateBuilder(
                x500name,
                BigInteger.valueOf(System.currentTimeMillis()),
                Date.from(Instant.now().minusSeconds(60 * 12)),
                Date.from(Instant.now().plusSeconds(60 * 60 * 24 * 365)),
                x500name,
                publicKey
        );

        X509Certificate cert = new JcaX509CertificateConverter().getCertificate(certGen.build(signer));

        // Output the certificate
        System.out.println(cert);
    }
}