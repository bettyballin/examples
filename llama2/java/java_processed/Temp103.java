import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;

public class Temp103 {
    public static void main(String[] args) {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLSv1.3");
            sslContext.init(null, null, null);
            SSLEngine sslEngine = sslContext.createSSLEngine();
            SSLParameters sslParameters = sslEngine.getSSLParameters();
            System.out.println("TLS Protocol Handler initialized with: " + sslParameters.getProtocols()[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}