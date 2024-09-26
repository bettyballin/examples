import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class SignatureVerification {
    public static void main(String[] args) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("Windows-MY");
        keyStore.load(null, null);

        Enumeration<String> en = keyStore.aliases();
        while (en.hasMoreElements()) {
            String aliasName = en.nextElement();
            X509Certificate certificate = (X509Certificate) keyStore.getCertificate(aliasName);
            if (certificate != null) {
                PublicKey publicKey = certificate.getPublicKey();
                // PrivateKey privateKey = (PrivateKey) keyStore.getKey(aliasName, null); // Commented out as it may not be used or may require a password
                System.out.println("Alias: " + aliasName + ", Public Key: " + publicKey);
            }
        }
    }
}