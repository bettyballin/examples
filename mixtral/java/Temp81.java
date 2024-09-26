import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class Temp81 {
    public static void main(String[] args) {
        String username = "yourUsername";
        String password = "yourPassword";
        String auth = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

        try {
            URL url = new URL("http://example.com"); // Replace with your URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", "Basic " + auth);

            // Send request
            InputStream in = connection.getInputStream();

            // Read response (optional, for demonstration)
            int data = in.read();
            while(data != -1) {
                System.out.print((char) data);
                data = in.read();
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}