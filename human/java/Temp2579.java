import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class Temp2579 {
    public static void main(String[] args) {
        try {
            // Get access token
            String tokenUrl = "http://localhost:9080/auth/realms/jhipster/protocol/openid-connect/token";
            String credentials = "web_app:web_app";
            String authHeaderValue = "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());
            String params = "username=admin&password=admin&grant_type=password&scope=read";
            URL url = new URL(tokenUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", authHeaderValue);
            conn.setDoOutput(true);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(params.getBytes());
                os.flush();
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Extract access token from response
            String accessToken = response.toString().split("\"access_token\":\"")[1].split("\"")[0];

            // Request to a secured API
            String apiUrl = "http://localhost:8080/api/account";
            URL apiURL = new URL(apiUrl);
            HttpURLConnection apiConn = (HttpURLConnection) apiURL.openConnection();
            apiConn.setRequestMethod("GET");
            apiConn.setRequestProperty("Authorization", "Bearer " + accessToken);

            BufferedReader apiIn = new BufferedReader(new InputStreamReader(apiConn.getInputStream()));
            String apiInputLine;
            StringBuffer apiResponse = new StringBuffer();
            while ((apiInputLine = apiIn.readLine()) != null) {
                apiResponse.append(apiInputLine);
            }
            apiIn.close();

            // Print the secured API response
            System.out.println("API Response: " + apiResponse.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}