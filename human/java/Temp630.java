import javax.net.ssl.*;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class Temp630 {
    public static void main(String[] args) throws Exception {
        // Initialize KeyManagerFactory with your server's keystore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        // Load the keystore here (this is just an example, replace with actual keystore loading code)
        keyStore.load(null, null);
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, "password".toCharArray()); // replace "password" with the keystore password

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init((KeyStore) null); // Use the default trust store
        TrustManager[] trustManagers = tmf.getTrustManagers();
        final X509TrustManager origTrustManager = (X509TrustManager) trustManagers[0];

        // Load your test CA certificate here (this is just a placeholder, replace with actual certificate loading code)
        X509Certificate caCert = null;

        X509TrustManager fakeTrustManager = new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                // Use the behaviour of the default trust manager.
                origTrustManager.checkClientTrusted(chain, authType);
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                // Use the behaviour of the default trust manager.
                origTrustManager.checkServerTrusted(chain, authType);
            }

            public X509Certificate[] getAcceptedIssuers() {
                // This is only used for sending the list of acceptable CA DNs.
                return new X509Certificate[]{caCert};
            }
        };
        trustManagers = new X509TrustManager[]{fakeTrustManager};

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), trustManagers, null);

        // Example of creating an SSL socket with the initialized SSLContext
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("example.com", 443);
        sslSocket.startHandshake();

        // Now you can use sslSocket to communicate securely
    }
}