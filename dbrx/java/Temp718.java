import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class Temp718 {
    public static void main(String[] args) {
        try {
            String[] enabledCiphers = {
                "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
                "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256",
                "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA",
                "SSL_RSA_WITH_3DES_EDE_CBC_SHA",
                "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA",
                "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA",
                "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
                "TLS_RSA_WITH_AES_128_CBC_SHA"
            };
            
            int port = 8443; // Example port number
            
            SSLServerSocketFactory ssf = (SSLServerSocketFactory) javax.net.ssl.SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket) ssf.createServerSocket(port);
            sslServerSocket.setEnabledCipherSuites(enabledCiphers);
            
            System.out.println("SSL Server Socket created and ciphers set.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}