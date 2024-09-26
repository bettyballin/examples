import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.time.Instant;
import java.util.Date;

public class CertificateGenerator {

    public static void main(String[] args) throws NoSuchAlgorithmException, OperatorCreationException, CertificateException {
        Security.addProvider(new BouncyCastleProvider());

        KeyPair keyPair = generateRSAKeyPair();
        X500Name issuerDN = new X500Name("CN=Issuer");
        BigInteger serialNumber = BigInteger.valueOf(System.currentTimeMillis());
        Date notBefore = Date.from(Instant.now().minusSeconds(60 * 60)); // changed to 1 hour
        Date notAfter = Date.from(notBefore.toInstant().plusSeconds(365 * 24 * 60 * 60));

        ContentSigner contentSigner = new JcaContentSignerBuilder("SHA256withRSA").build(keyPair.getPrivate());
        X509v3CertificateBuilder certificateBuilder =
                new X509v3CertificateBuilder(
                        issuerDN,
                        serialNumber,
                        notBefore,
                        notAfter,
                        issuerDN,
                        keyPair.getPublic()
                );

        JcaX509CertificateConverter converter = new JcaX509CertificateConverter();
        converter.setProvider(new BouncyCastleProvider()); // added provider
        X509Certificate cert = converter.getCertificate(certificateBuilder.build(contentSigner));

        System.out.println("Generated certificate: " + cert);
    }

    private static KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA", new BouncyCastleProvider()); // added provider
        keyGen.initialize(2048); // 1024 bits is not secure anymore
        return keyGen.generateKeyPair();
    }
}