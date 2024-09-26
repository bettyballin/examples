import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Temp721 {
    
    private static final Logger LOGGER = Logger.getLogger(Temp721.class.getName());

    public static void main(String[] args) {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);

            // Check if private key exists before attempting to retrieve it.
            if (keyStore.containsAlias("alias")) {
                try {
                    // Generating key pair omitted

                    PrivateKey privateKey = ((KeyStore.PrivateKeyEntry) keyStore.getEntry("alias", null)).getPrivateKey();
                } catch (UnrecoverableKeyException e) {
                    LOGGER.log(Level.SEVERE, "Failed to obtain information about private key: ", e);
                }
            } else {
                // Handle the case when no alias is found
                LOGGER.info("No alias found.");
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred: ", e);
        }
    }
}