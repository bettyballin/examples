import javax.net.ssl.*;
import java.net.URL;

public class Temp1284 {
    public static void main(String[] args) {
        try {
            String url = "https://your_soap_service_url";
            
            SSLContext context = SSLContext.getInstance("TLSv1.2");
            context.init(null, null, new java.security.SecureRandom());
            
            HttpsURLConnection connection = (HttpsURLConnection) new URL(url).openConnection();
            connection.setSSLSocketFactory(context.getSocketFactory());
            
            // Additional code for handling the connection can be added here.
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}