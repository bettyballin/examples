import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLContext;
import javax.net.ssl.NoSuchAlgorithmException;

public class Temp3449 {
    public static void main(String[] args) {
        try {
            SSLContext serverSslContext = SSLContext.getInstance("TLS");
            serverSslContext.init(null, null, null);
            SSLEngine serverEngine = serverSslContext.createSSLEngine();
            serverEngine.setEnabledProtocols(new String[] { "TLSv1.2", "TLSv1.3" });
            System.out.println("SSLEngine created and protocols set successfully.");
        } catch (NoSuchAlgorithmException | java.security.KeyManagementException e) {
            e.printStackTrace();
        }
    }
}