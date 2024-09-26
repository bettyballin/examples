import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

public class Temp568 {
    public static void main(String[] args) {
        try {
            // Generate a key pair
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair kp = keyPairGenerator.generateKeyPair();

            X500Name issuerDN = new X500Name("CN=Test CA");
            BigInteger serialNumber = BigInteger.valueOf(System.currentTimeMillis());
            Date notBefore = new Date();
            Date notAfter = new Date(notBefore.getTime() + 365L * 24 * 60 * 60 * 1000);
            PublicKey publicKey = kp.getPublic();

            X509v3CertificateBuilder certGen = new X509v3CertificateBuilder(
                issuerDN,
                serialNumber,
                notBefore,
                notAfter,
                issuerDN,
                publicKey
            );

            ContentSigner sigGen = new JcaContentSignerBuilder("SHA1withRSA")
                .build(kp.getPrivate());

            java.security.Security.addProvider(new BouncyCastleProvider());

            X509Certificate certificate = new JcaX509CertificateConverter()
                .setProvider("BC").getCertificate(certGen.build(sigGen));

            System.out.println("Certificate: " + certificate);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}