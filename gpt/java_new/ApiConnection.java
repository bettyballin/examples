import java.net.HttpURLConnection;
import java.net.URL;

public class ApiConnection {
    public static void main(String[] args) {
        try {
            // Define your API key (store it securely in your app)
            String apiKey = "your_unique_api_key";
            // Assuming URL is a valid endpoint
            String URL = "https://api.example.com/data";

            // Configure the HTTP request to include the API key in the header
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(URL).openConnection();
            urlConnection.setRequestProperty("Authorization", "Bearer " + apiKey);

            // Rest of your code to handle the connection and receive the XML response
            // For example:
            // int responseCode = urlConnection.getResponseCode();
            // InputStream inputStream;
            // if (responseCode == HttpURLConnection.HTTP_OK) {
            //     inputStream = urlConnection.getInputStream();
            // } else {
            //     inputStream = urlConnection.getErrorStream();
            // }
            // // Process the inputStream...
            
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}