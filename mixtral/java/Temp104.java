import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp104 {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        // Generate RSA keypair
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair keyPair = kpg.generateKeyPair();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // Create a self-signed X509Certificate
        X500Name x500name = new X500Name("CN=MyTestCert");
        BigInteger serialNumber = BigInteger.valueOf(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        Date startDate = calendar.getTime();
        calendar.add(Calendar.YEAR, 1);
        Date endDate = calendar.getTime();

        X509v3CertificateBuilder certBuilder = new JcaX509v3CertificateBuilder(
                x500name, serialNumber, startDate, endDate, x500name, publicKey
        );
        ContentSigner signer = new JcaContentSignerBuilder("SHA256withRSA").build(privateKey);
        X509Certificate cert = new JcaX509CertificateConverter().setProvider("BC").getCertificate(certBuilder.build(signer));

        // Store the private key and certificate in a PKCS12 KeyStore
        char[] password = "password".toCharArray();
        String alias = "myalias";
        KeyStore ks = KeyStore.getInstance("PKCS12");
        ks.load(null, null);

        X509Certificate[] certChain = new X509Certificate[1];
        certChain[0] = cert;

        ks.setKeyEntry(alias, privateKey, password, certChain);

        try (FileOutputStream fos = new FileOutputStream("keystore.p12")) {
            ks.store(fos, password);
        }
    }
}