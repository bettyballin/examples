import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Temp2610 {
    public static void main(String[] args) {
        try {
            String token = getTokenFromLocalStorage();
            if (token != null) {
                makeRequestWithToken(token);
            } else {
                System.out.println("Token not found in local storage.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getTokenFromLocalStorage() {
        // Simulating local storage with a hardcoded token
        // Replace this method to actually retrieve the token from local storage
        return "your_token_here";
    }

    private static void makeRequestWithToken(String token) throws IOException {
        String baseURL = "http://localhost:8080/";
        URL url = new URL(baseURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer " + token);

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
        // Add more code to handle the response if needed
    }
}