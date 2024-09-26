import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class Temp1839 {
    public static void main(String[] args) {
        try {
            // First curl command equivalent
            String userCredentials = "user:password";
            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));

            URL url = new URL("http://localhost:8080/oauth/token?grant_type=client_credentials");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", basicAuth);
            connection.setDoOutput(true);

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String tokenResponse = response.toString();
            System.out.println("Token Response: " + tokenResponse);

            // Assuming the token is extracted here from tokenResponse
            String token = "extracted_token"; // Replace with actual token extraction logic

            // Second curl command equivalent
            URL url2 = new URL("http://localhost:8080/...");
            HttpURLConnection connection2 = (HttpURLConnection) url2.openConnection();
            connection2.setRequestMethod("GET");
            connection2.setRequestProperty("Authorization", "Bearer " + token);

            int responseCode2 = connection2.getResponseCode();
            System.out.println("Response Code: " + responseCode2);

            BufferedReader in2 = new BufferedReader(new InputStreamReader(connection2.getInputStream()));
            String inputLine2;
            StringBuffer response2 = new StringBuffer();

            while ((inputLine2 = in2.readLine()) != null) {
                response2.append(inputLine2);
            }
            in2.close();

            System.out.println("Response: " + response2.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}