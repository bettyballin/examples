import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import java.security.KeyStore;

public class Temp865 {
    public static void main(String[] args) throws Exception {
        // Initialize a new KeyStore instance
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        
        // Load the KeyStore with null inputs, which means to use the default KeyStore
        keyStore.load(null, null);

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(keyStore);

        X509TrustManager x509Tm = null;
        for (TrustManager trustManager : tmf.getTrustManagers()) {
            if (trustManager instanceof X509TrustManager) {
                x509Tm = (X509TrustManager) trustManager;
                break;
            }
        }

        if (x509Tm != null) {
            System.out.println("X509TrustManager initialized successfully.");
        } else {
            System.out.println("X509TrustManager could not be initialized.");
        }
    }
}