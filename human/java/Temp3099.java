import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserService {

    private static final String API_URL = "http://localhost:8080/api/test/";

    public String getPublicContent() throws IOException {
        String urlString = API_URL + "all";
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();

        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        }
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        try {
            String content = userService.getPublicContent();
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}