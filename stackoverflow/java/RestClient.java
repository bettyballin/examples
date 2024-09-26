import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class RestClient {
    public static void main(String[] args) {
        String accessToken = OAuth2Client.generateAccessToken();
        String url = "http://example.com/api/resource"; // Replace with actual URL
        String request = "{\"key\": \"value\"}"; // Replace with actual JSON request

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);

        HttpEntity<String> entity = new HttpEntity<>(request, headers);
        String response = restTemplate.postForObject(url, entity, String.class);
        
        System.out.println(response);
    }
    
    private static class OAuth2Client {
        static String generateAccessToken() {
            // Implementation of access token generation
            return "your_access_token";
        }
    }
}