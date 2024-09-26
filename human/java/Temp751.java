import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;

public class Temp751 {
    public static void main(String[] args) {
        try {
            String certificateFile = "path/to/your/certificate.p12"; // Replace with your certificate file path
            String certificatePassword = "yourPassword"; // Replace with your certificate password
            String certName = "yourCertAlias"; // Replace with your certificate alias

            KeyStore keystore = KeyStore.getInstance("PKCS12");
            keystore.load(new FileInputStream(certificateFile), certificatePassword.toCharArray());
            Key key = keystore.getKey(certName, certificatePassword.toCharArray());
            Certificate cert = keystore.getCertificate(certName);
            PublicKey publicKey = cert.getPublicKey();
            KeyPair keys = new KeyPair(publicKey, (PrivateKey) key);

            System.out.println("Public Key: " + publicKey);
            System.out.println("Private Key: " + key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}