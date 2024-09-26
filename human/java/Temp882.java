import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.interfaces.RSAPublicKey;

public class Temp882 {
    public static void main(String[] args) {
        byte[] publicKey = getPublicKey();
        if (publicKey != null) {
            System.out.println("Public key: " + java.util.Base64.getEncoder().encodeToString(publicKey));
        } else {
            System.out.println("Failed to retrieve public key.");
        }
    }

    public static byte[] getPublicKey() {
        try {
            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            // Load the keystore. Provide the path to your keystore and the password
            java.io.FileInputStream fis = new java.io.FileInputStream("path/to/keystore.jks");
            keystore.load(fis, "keystore-password".toCharArray());
            fis.close();

            Certificate cert = keystore.getCertificate("alias");
            if (cert != null) {
                RSAPublicKey key = (RSAPublicKey) cert.getPublicKey();
                return key.getModulus().toByteArray();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}