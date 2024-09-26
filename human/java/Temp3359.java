import javax.net.ssl.HttpsURLConnection;
import java.net.URL;

public class Temp3359 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.com");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            
            // Example usage of the connection
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}