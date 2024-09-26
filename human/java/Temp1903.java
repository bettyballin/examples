import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Temp1903 {
    public static void main(String[] args) {
        String tokenUrl = "your_token_url";
        String model = "{\"your_key\": \"your_value\"}";
        String headers1 = "Content-Type: application/json"; // Modify headers as needed

        try {
            URL url = new URL(tokenUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = model.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}