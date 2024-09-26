import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class Main {
    public static void main(String[] args) {
        // Assuming OAuth2Client is a class that you have which contains the method generateAccessToken
        String accessToken = OAuth2Client.generateAccessToken();
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);

        String request = "{}"; // Replace with your actual request body
        String url = "http://example.com/api"; // Replace with your actual URL

        HttpEntity<String> entity = new HttpEntity<>(request, headers);
        String response = restTemplate.postForObject(url, entity, String.class);

        System.out.println(response);
    }
}

class OAuth2Client {
    public static String generateAccessToken() {
        // Mock implementation, replace with actual logic to generate access token
        return "mock-access-token";
    }
}