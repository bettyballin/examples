import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, CertificateException, IOException, KeyStoreException {
        CustomSSLContext sslContext = new CustomSSLContext("keyStore", "password");
        SSLContext.setDefault(sslContext.getSSLContext());
    }
}

class CustomSSLContext {
    private SSLContext sslContext;

    public CustomSSLContext(String keyStorePath, String password) throws NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException {
        sslContext = SSLContext.getInstance("TLS");
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(keyStorePath), password.toCharArray());
        sslContext.init(null, null, null);
    }

    public SSLContext getSSLContext() {
        return sslContext;
    }
}