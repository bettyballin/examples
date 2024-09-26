import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyStore;
import java.security.KeyStore.ProtectionParameter;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

public class Temp3017 {

    private static final String KEY_ALIAS = "mySecretKey";
    private static final String KEYSTORE_TYPE = "JCEKS";
    private static KeyStore keyStore;
    private static KeyGenerator keyGenerator;

    public static void main(String[] args) {
        try {
            // Initialize KeyGenerator
            keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256); // You can specify the key size
            
            // Generate SecretKey
            SecretKey k = keyGenerator.generateKey();

            // Initialize KeyStore
            keyStore = KeyStore.getInstance(KEYSTORE_TYPE);
            keyStore.load(null, null); // Initialize KeyStore

            // Set SecretKeyEntry
            keyStore.setEntry(
                KEY_ALIAS,
                new KeyStore.SecretKeyEntry(k),
                getProtectionParameter()
            );

            System.out.println("SecretKey has been stored in the KeyStore with alias: " + KEY_ALIAS);

        } catch (NoSuchAlgorithmException | KeyStoreException | java.security.cert.CertificateException | java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private static ProtectionParameter getProtectionParameter() {
        // Return a simple PasswordProtection parameter
        return new KeyStore.PasswordProtection("password".toCharArray());
    }
}