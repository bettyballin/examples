import java.io.IOException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;

public class KeyStoreExample {

    public void loadKeyStore(String alias) {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);

            PublicKey publicKey = keyStore.getCertificate(alias).getPublicKey();
            // You can now use the public key to encrypt data
            // ...
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
            // Handle exceptions
        }
    }

    public static void main(String[] args) {
        new KeyStoreExample().loadKeyStore("your_alias");
    }
}