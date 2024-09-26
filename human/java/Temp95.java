import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import java.net.HttpURLConnection;
import java.net.URL;

public class Temp95 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.com");
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, null, new java.security.SecureRandom());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (connection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) connection).setSSLSocketFactory(sc.getSocketFactory());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}