import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLContext;
import java.net.URL;

public class Temp976 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.com");
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

            con.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, null, new java.security.SecureRandom());
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            con.setSSLSocketFactory(sslSocketFactory);

            // Add your code to connect and retrieve data here

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}