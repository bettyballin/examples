import javax.net.ssl.*;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.io.IOException;

public class CustomSSLContext extends SSLContextSpi {

    private final KeyManager[] keyManagers;
    private final TrustManager[] trustManagers;
    private SSLContext context;

    public CustomSSLContext(KeyStore keystore, String password) throws NoSuchAlgorithmException, CertificateException, IOException, KeyStoreException, UnrecoverableKeyException {
        this.keyManagers = new KeyManager[]{new CustomX509KeyManager(keystore, password)};
        this.trustManagers = new TrustManager[]{new DefaultTrustManager()};
        this.context = SSLContext.getInstance("TLS");
        this.context.init(keyManagers, trustManagers, new SecureRandom());
    }

    @Override
    protected void engineInit(KeyManager[] km, TrustManager[] tm, SecureRandom sr) throws KeyManagementException {
        context.init(km, tm, sr);
    }

    @Override
    protected SSLSocketFactory engineGetSocketFactory() {
        return context.getSocketFactory();
    }

    @Override
    protected SSLServerSocketFactory engineGetServerSocketFactory() {
        return context.getServerSocketFactory();
    }

    @Override
    protected SSLEngine engineCreateSSLEngine() {
        return context.createSSLEngine();
    }

    @Override
    protected SSLEngine engineCreateSSLEngine(String host, int port) {
        return context.createSSLEngine(host, port);
    }

    @Override
    protected SSLSessionContext engineGetServerSessionContext() {
        return context.getServerSessionContext();
    }

    @Override
    protected SSLSessionContext engineGetClientSessionContext() {
        return context.getClientSessionContext();
    }

    private static class CustomX509KeyManager implements X509KeyManager {
        private final KeyStore keystore;
        private final String password;

        public CustomX509KeyManager(KeyStore keystore, String password) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
            this.keystore = keystore;
            this.password = password;
        }

        @Override
        public String[] getClientAliases(String keyType, Principal[] issuers) {
            return new String[0];
        }

        @Override
        public String chooseClientAlias(String[] keyType, Principal[] issuers, Socket socket) {
            return null;
        }

        @Override
        public String[] getServerAliases(String keyType, Principal[] issuers) {
            return new String[0];
        }

        @Override
        public String chooseServerAlias(String keyType, Principal[] issuers, Socket socket) {
            return null;
        }

        @Override
        public X509Certificate[] getCertificateChain(String alias) {
            try {
                return new X509Certificate[]{(X509Certificate) keystore.getCertificate(alias)};
            } catch (KeyStoreException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public PrivateKey getPrivateKey(String alias) {
            try {
                return (PrivateKey) keystore.getKey(alias, password.toCharArray());
            } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private static class DefaultTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            // Implement your trust verification logic here
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            // Implement your trust verification logic here
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}