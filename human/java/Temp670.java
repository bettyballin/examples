import javax.crypto.spec.SecretKeySpec;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Temp670 {

    private static final String TAG = "Temp670";
    private static KeyStore mKeystore;
    private static String mKeyStoreName = "MyKeyStore";

    public static void main(String[] args) {
        // Initialize the keystore (for demonstration purposes only)
        try {
            mKeystore = KeyStore.getInstance(KeyStore.getDefaultType());
            mKeystore.load(null, null); // Initialize with empty keystore
        } catch (Exception e) {
            Logger.getLogger(TAG).log(Level.SEVERE, "Failed to initialize keystore", e);
        }

        Temp670 temp = new Temp670();
        String entry = temp.getEntry("myAlias");
        System.out.println("Keystore entry: " + entry);
    }

    public String getEntry(String alias) {

        String secretStr = null;
        byte[] secret = null;

        if (mKeystore != null) {

            try {
                if (!mKeystore.containsAlias(alias)) {
                    Logger.getLogger(TAG).log(Level.WARNING, "Keystore " + mKeyStoreName + " does not contain entry " + alias);
                    return null;
                }
            } catch (KeyStoreException ex) {
                Logger.getLogger(TAG).log(Level.SEVERE, "Failed to read keystore entry " + alias, ex);
            }

            // get my entry from the key store
            KeyStore.ProtectionParameter pp = new KeyStore.PasswordProtection(null);
            KeyStore.SecretKeyEntry ske = null;
            try {
                ske = (KeyStore.SecretKeyEntry) mKeystore.getEntry(alias, pp);
            } catch (Exception ex) {
                Logger.getLogger(TAG).log(Level.SEVERE, "Failed to read keystore entry " + alias, ex);
            }

            if (ske != null) {
                SecretKeySpec sks = (SecretKeySpec) ske.getSecretKey();
                secret = sks.getEncoded();

                if (secret != null) {
                    secretStr = new String(secret);
                } else {
                    Logger.getLogger(TAG).log(Level.SEVERE, "Read empty keystore entry " + alias);
                }
            } else {
                Logger.getLogger(TAG).log(Level.SEVERE, "Failed to read keystore entry " + alias);
            }
        }
        return secretStr;
    }
}