import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509KeyManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

public class SSLManager {

    private static final String SSL_KEYSTORE = "ssl.keystore";
    private static final String SSL_KEYSTORE_PASSWORD = "ssl.keystorePassword";
    
    private static KeyManager[] getKeyManagers(Properties props) throws IOException, GeneralSecurityException {
        KeyManagerFactory kmFact = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        FileInputStream fis = new FileInputStream(props.getProperty(SSL_KEYSTORE));
        KeyStore ks = KeyStore.getInstance("jks");
        String keyStorePassword = props.getProperty(SSL_KEYSTORE_PASSWORD);
        ks.load(fis, keyStorePassword.toCharArray());
        fis.close();
        kmFact.init(ks, keyStorePassword.toCharArray());
        return kmFact.getKeyManagers();
    }

    private static void initialiseManager(Properties props) throws IOException, GeneralSecurityException {
        SSLContext context = SSLContext.getInstance("SSL");
        context.init(getKeyManagers(props), null, null);
        SSLContext.setDefault(context);
    }

    // Additional methods like getTrustManagers() not shown for brevity
}