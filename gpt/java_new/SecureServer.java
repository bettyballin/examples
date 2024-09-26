import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.security.KeyStore;
import java.io.FileInputStream;
import java.security.SecureRandom;

public class SecureServer {
    public static void main(String[] args) throws Exception {
        // Load server private key and certificate
        KeyStore keyStore = KeyStore.getInstance("JKS");
        char[] password = "keystorepassword".toCharArray();
        keyStore.load(new FileInputStream("server.keystore"), password);

        // Set up key manager factory to use our key store
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, password);

        // Set up the SSL context
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(kmf.getKeyManagers(), null, new SecureRandom());

        // Create the SSL server socket factory
        SSLServerSocketFactory ssf = context.getServerSocketFactory();

        // Create server socket
        SSLServerSocket s = (SSLServerSocket) ssf.createServerSocket(12345);

        // ... handle client connections
    }
}