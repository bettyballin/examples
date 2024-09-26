import java.security.InvalidKeyException;
import java.security.KeyStore;

public class Temp1782 {
    private KeyStore keyStore;

    public Temp1782(KeyStore keyStore) {
        this.keyStore = keyStore;
    }

    public void execute(String keyName, boolean retry) {
        try {
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) this.keyStore.getEntry("alias", null);
            // Use the privateKeyEntry as needed
        } catch (final Exception e) {
            e.printStackTrace();
            if (e instanceof InvalidKeyException) { // bypass InvalidKeyException
                // You can again call the method and make a counter for deadlock situation or implement your own code according to your situation
                try {
                    if (retry) {
                        keyStore.deleteEntry(keyName);
                        execute(keyName, false); // Retry
                    } else {
                        throw e;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            // Initialize the keystore, e.g., load it from a file or create a new one
            keyStore.load(null, null); // Initialize with null or proper InputStream and password

            Temp1782 temp1782 = new Temp1782(keyStore);
            temp1782.execute("yourKeyAlias", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}