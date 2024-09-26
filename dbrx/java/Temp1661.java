import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLEngine;

public class Temp1661 {
    public static void main(String[] args) {

        System.setProperty("javax.net.ssl.keyStore", "/path/to/keystore.p12");
        System.setProperty("javax.net.ssl.keyStorePassword", "your_password_here");

        // Now create your SSLEngine SSLServerSocketFactory etc.
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLEngine sslEngine = sslServerSocketFactory.createSSLEngine();
    }
}