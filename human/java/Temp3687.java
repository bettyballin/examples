import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class Temp3687 {
    public static void main(String[] args) {
        withBasicAuth("RealUser", "RealPassword");
    }

    public static void withBasicAuth(String user, String password) {
        try {
            URL url = new URL("http://example.com"); // Replace with your URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            String encoded = Base64.getEncoder().encodeToString((user + ":" + password).getBytes("UTF-8"));
            connection.setRequestProperty("Authorization", "Basic " + encoded);
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Additional code to read the response can be added here

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}