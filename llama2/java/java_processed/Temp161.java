import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;
import sun.security.x509.*;

public class Temp161 {
    public static void main(String[] args) {
        try {
            // Generate a key pair
            KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
            kg.initialize(2048, new SecureRandom());
            KeyPair kp = kg.generateKeyPair();

            // Create a self-signed certificate
            X500Name owner = new X500Name("CN=Test Certificate");
            X509CertInfo certInfo = new X509CertInfo();
            Date from = new Date();
            Date to = new Date(from.getTime() + 365 * 86400000L); // 1 year validity
            CertificateValidity interval = new CertificateValidity(from, to);
            BigInteger sn = new BigInteger(64, new SecureRandom());
            AlgorithmId algo = new AlgorithmId(AlgorithmId.sha1WithRSAEncryption_oid);

            certInfo.set(X509CertInfo.VALIDITY, interval);
            certInfo.set(X509CertInfo.SERIAL_NUMBER, new CertificateSerialNumber(sn));
            certInfo.set(X509CertInfo.SUBJECT, owner);
            certInfo.set(X509CertInfo.ISSUER, owner);
            certInfo.set(X509CertInfo.KEY_USAGE, X509CertInfo.KEY_usageKeyEvent);
            certInfo.set(X509CertInfo.KEY, new CertificateX509Key(kp.getPublic()));
            certInfo.set(X509CertInfo.VERSION, new CertificateVersion(CertificateVersion.V3));
            certInfo.set(X509CertInfo.ALGORITHM_ID, new CertificateAlgorithmId(algo));

            X509CertImpl cert = new X509CertImpl(certInfo);
            cert.sign(kp.getPrivate(), "SHA1withRSA");

            // Store the private key and certificate in a KeyStore
            KeyStore ks = KeyStore.getInstance("JKS");
            ks.load(null, null);

            KeyStore.PrivateKeyEntry pke = new KeyStore.PrivateKeyEntry(kp.getPrivate(), new Certificate[]{cert});
            KeyStore.PasswordProtection pp = new KeyStore.PasswordProtection("password".toCharArray());
            ks.setEntry("mykey", pke, pp);

            // Save the keystore to file
            try (java.io.FileOutputStream fos = new java.io.FileOutputStream("keystore.jks")) {
                ks.store(fos, "password".toCharArray());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}