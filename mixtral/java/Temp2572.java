import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import java.net.URL;
import java.security.cert.X509Certificate;

public class Temp2572 {
    public static void main(String[] args) {
        try {
            TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
            };

            SSLContext sslcontext = SSLContext.getInstance("TLS");
            sslcontext.init(null, trustAllCerts, new java.security.SecureRandom());

            HostnameVerifier hv = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            HttpsURLConnection con = (HttpsURLConnection) new URL("https://example.com").openConnection();
            con.setSSLSocketFactory(sslcontext.getSocketFactory());
            con.setHostnameVerifier(hv);

            // Now you can use the connection as usual
            System.out.println("Connection established: " + con.getResponseCode());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}