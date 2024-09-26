import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Temp750 {
    public static void main(String[] args) {
        try {
            // Load the certificate from a file
            FileInputStream fis = new FileInputStream("path/to/certificate/file");
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(fis);

            // Load the keystore containing the private key
            KeyStore keystore = KeyStore.getInstance("PKCS12");
            char[] password = "certificatePassword".toCharArray();
            FileInputStream ksFis = new FileInputStream("path/to/keystore/file");
            keystore.load(ksFis, password);

            // Retrieve the private key from the keystore
            PrivateKey privateKey = (PrivateKey) keystore.getKey("alias", password);

            // Retrieve the public key from the certificate
            java.security.PublicKey publicKey = cert.getPublicKey();

            // Print the keys to verify
            System.out.println("Public Key: " + publicKey);
            System.out.println("Private Key: " + privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}