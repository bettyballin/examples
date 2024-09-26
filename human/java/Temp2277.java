import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class Temp2277 {
    private static final char[] JKS_PRIVATE_FILE_PASSWORD = "password".toCharArray();

    public static void main(String[] args) {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null); // Initialize a new key store

            try (FileOutputStream out = new FileOutputStream("keystore.jks")) {
                keyStore.store(out, JKS_PRIVATE_FILE_PASSWORD);
                System.out.println("Keystore successfully stored.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
            e.printStackTrace();
        }
    }
}