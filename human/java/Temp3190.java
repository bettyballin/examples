import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import java.net.URL;

public class Temp3190 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.com");
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, null, new java.security.SecureRandom());
            
            HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
            conn.setSSLSocketFactory(context.getSocketFactory());
            
            System.out.println("Connection established successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}