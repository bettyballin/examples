import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Temp3334 {
    public static void main(String[] args) {
        try {
            String SERVER_URL = "http://example.com"; // Replace with actual server URL
            String email = "user@example.com"; // Replace with actual email
            String postData = "{\"email\": \"" + email + "\"}";

            URL url = new URL(SERVER_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = postData.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            try (InputStream is = conn.getInputStream()) {
                int responseCode = conn.getResponseCode();
                System.out.println("Response Code: " + responseCode);
                // Read the response if needed
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}