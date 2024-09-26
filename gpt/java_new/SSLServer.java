import javax.net.ssl.*;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.SecureRandom;

public class SSLServer {
    public static void main(String[] args) throws Exception {
        int port = 8443; // Replace with your desired port
        String sslstore = "keystore.jks"; // Replace with your keystore path
        char[] sslstorepass = "storepass".toCharArray(); // Replace with your keystore password
        char[] sslcertpass = "certpass".toCharArray(); // Replace with your certificate password

        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream(sslstore), sslstorepass);
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(ks, sslcertpass);

        SSLContext sc = SSLContext.getInstance("TLSv1.2");
        sc.init(kmf.getKeyManagers(), null, new SecureRandom());
        SSLServerSocketFactory ssf = sc.getServerSocketFactory();
        SSLServerSocket serverSocket = (SSLServerSocket) ssf.createServerSocket(port);

        // Example cipher suite, use the ones you need
        String[] enabledCipherSuites = {"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256"};
        serverSocket.setEnabledCipherSuites(enabledCipherSuites);

        // Server is now ready to accept connections
    }
}