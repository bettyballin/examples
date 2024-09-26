import javax.net.ssl.*;
import java.security.*;
import java.security.cert.X509Certificate;

public class Temp1564 {
    public static void main(String[] args) throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() { return null; }
                public void checkClientTrusted(X509Certificate[] certs, String authType) { }
                public void checkServerTrusted(X509Certificate[] certs, String authType) { }
            }
        };

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustAllCerts, new SecureRandom());
        SSLSocketFactory socketFactory = sslContext.getSocketFactory();

        // Creating a dummy SSL socket to demonstrate setting protocols
        SSLSocket socket = (SSLSocket) socketFactory.createSocket();
        String[] protocols = {"TLSv1.2", "TLSv1.3"};
        socket.setEnabledProtocols(protocols);
        
        System.out.println("Enabled Protocols: " + String.join(", ", socket.getEnabledProtocols()));
    }
}