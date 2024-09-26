import java.net.HttpURLConnection;
import java.net.URL;

public class Main45 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            String tokenValue = "your_csrf_token_here";
            connection.setRequestProperty("X-CSRF-TOKEN", tokenValue);
            // Rest of the code to handle the connection
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}