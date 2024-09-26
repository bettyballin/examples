import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class Main96 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.com"); // replace with your URL
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            // Use connection...
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}