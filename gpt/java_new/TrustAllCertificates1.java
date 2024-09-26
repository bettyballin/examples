import javax.net.ssl.*;
import java.security.cert.X509Certificate;
import java.security.SecureRandom;

public class TrustAllCertificates1 {
    public static void main(String[] args) {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        // No need to implement
                    }
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        // No need to implement
                    }
                }
            };

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Example of creating a connection
            // URL url = new URL("https://your-secure-url.com");
            // HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}