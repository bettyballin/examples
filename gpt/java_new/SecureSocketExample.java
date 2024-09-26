import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SecureSocketExample {
    public void createSecureSocket() {
        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) factory.createSocket("host", 443);
            // Use the SSLSocket as needed
            // ...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}