import java.security.KeyStore;
import java.security.KeyStoreException;

public class KeyStoreFinder {
    public static void main(String[] args) {
        try {
            KeyStore defaultKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            defaultKeyStore.load(null, null);
            System.out.println("Using key store: " + defaultKeyStore.getType());
        } catch (KeyStoreException | java.io.IOException | java.security.NoSuchAlgorithmException | java.security.cert.CertificateException e) {
            e.printStackTrace();
        }
    }
}