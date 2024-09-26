import java.io.ByteArrayOutputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.KeyStore.PrivateKeyEntry;

public class Temp288 {
    public static void main(String[] args) {
        try {
            // Example usage
            Certificate cert = null;  // Replace with actual certificate
            PrivateKey privkey = null;  // Replace with actual private key
            new Temp288().generateInMemoryKeystore(cert, privkey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateInMemoryKeystore(Certificate cert, PrivateKey privkey) throws Exception {
        // Create an empty keystore
        KeyStore keyStore = KeyStore.getInstance("JKS");

        char[] password = "password".toCharArray();

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            keyStore.load(null, null);

            // Add the certificate and private keys to keystore
            KeyStore.Entry entry = new PrivateKeyEntry(privkey, new Certificate[]{cert});

            keyStore.setEntry("alias", entry, new KeyStore.PasswordProtection(password));
        }
    }
}