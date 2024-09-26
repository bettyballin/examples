import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.UnrecoverableKeyException;

public class Temp973 {
    private static final int MAX_RETRIES = 3;
    private KeyStore keyStore; // Assuming this is initialized somewhere

    public static void main(String[] args) {
        Temp973 temp = new Temp973();
        temp.loadPrivateKey();
    }

    public void loadPrivateKey() {
        boolean success = false;

        // Retry up to 'MAX_RETRIES' times with exponential backoff
        for (int retryCount = 0; !success && retryCount < MAX_RETRIES; ++retryCount) {
            try {
                KeyStore.PrivateKeyEntry privateKeyEntry =
                       (KeyStore.PrivateKeyEntry) this.keyStore.getEntry("alias", null);

                // Use the key

                success = true;

            } catch (UnrecoverableKeyException | KeyStoreException e) {
                if (retryCount < MAX_RETRIES - 1) {
                    int delayMillis = (int)(Math.pow(2, retryCount) + 5);

                    try {
                        Thread.sleep(delayMillis);

                    } catch (InterruptedException e1) {
                        Thread.currentThread().interrupt();
                    }
                }

                if (!success && retryCount == MAX_RETRIES - 1) {
                    throw new RuntimeException("Failed to load private key after " +
                            MAX_RETRIES + " attempts", e);
                }
            }
        }
    }
}