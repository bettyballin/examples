import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Temp43 {
    private static final Logger logger = LoggerFactory.getLogger(Temp43.class);
    private static final String SSL_KEYSTORE = "ssl_keystore";
    private static final String SSL_KEYSTORE_PASSWORD = "ssl_keystore_password";

    public static void main(String[] args) {
        // Example usage
        Properties props = new Properties();
        props.setProperty(SSL_KEYSTORE, "path/to/keystore.jks");
        props.setProperty(SSL_KEYSTORE_PASSWORD, "password");

        try {
            initialiseManager(props);
        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    private static KeyManager[] getKeyManagers(Properties props) throws IOException, GeneralSecurityException {
        String alg = KeyManagerFactory.getDefaultAlgorithm();
        KeyManagerFactory kmFact = KeyManagerFactory.getInstance(alg);
        FileInputStream fis = new FileInputStream(props.getProperty(SSL_KEYSTORE));
        logger.info("Loaded keystore");
        KeyStore ks = KeyStore.getInstance("jks");
        String keyStorePassword = props.getProperty(SSL_KEYSTORE_PASSWORD);
        ks.load(fis, keyStorePassword.toCharArray());
        fis.close();
        kmFact.init(ks, keyStorePassword.toCharArray());

        KeyManagerFactory dkmFact = KeyManagerFactory.getInstance(alg);
        dkmFact.init(null, null);

        X509KeyManager customX509KeyManager = getX509KeyManager(alg, kmFact);
        X509KeyManager jvmX509KeyManager = getX509KeyManager(alg, dkmFact);

        KeyManager[] km = { new MultiKeyStoreManager(jvmX509KeyManager, customX509KeyManager) };
        logger.debug("Number of key managers registered:" + km.length);
        return km;
    }

    private static X509KeyManager getX509KeyManager(String algorithm, KeyManagerFactory kmFact)
            throws NoSuchAlgorithmException {
        KeyManager[] keyManagers = kmFact.getKeyManagers();

        if (keyManagers == null || keyManagers.length == 0) {
            throw new NoSuchAlgorithmException("The default algorithm :" + algorithm + " produced no key managers");
        }

        X509KeyManager x509KeyManager = null;

        for (KeyManager keyManager : keyManagers) {
            if (keyManager instanceof X509KeyManager) {
                x509KeyManager = (X509KeyManager) keyManager;
                break;
            }
        }

        if (x509KeyManager == null) {
            throw new NoSuchAlgorithmException("The default algorithm :" + algorithm + " did not produce a X509 Key manager");
        }
        return x509KeyManager;
    }

    private static void initialiseManager(Properties props) throws IOException, GeneralSecurityException {
        SSLContext context = SSLContext.getInstance("SSL");
        context.init(getKeyManagers(props), getTrustManagers(props), null);
        SSLContext.setDefault(context);
    }

    private static TrustManager[] getTrustManagers(Properties props) throws IOException, GeneralSecurityException {
        // Implement this method as per your requirement
        return null;
    }

    private static class MultiKeyStoreManager extends X509ExtendedKeyManager {
        private final X509KeyManager jvmKeyManager;
        private final X509KeyManager customKeyManager;

        public MultiKeyStoreManager(X509KeyManager jvmKeyManager, X509KeyManager customKeyManager) {
            this.jvmKeyManager = jvmKeyManager;
            this.customKeyManager = customKeyManager;
        }

        // Implement required methods by delegating to jvmKeyManager and customKeyManager
    }
}