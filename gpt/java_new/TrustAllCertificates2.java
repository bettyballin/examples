import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.security.SecureRandom;

public class TrustAllCertificates2 {
    public static void main(String[] args) {
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    // Trust all clients.
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    // Trust all servers.
                }
            }
        };

        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            // Now you can use sc to create your ssl socket or ssl server socket
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}