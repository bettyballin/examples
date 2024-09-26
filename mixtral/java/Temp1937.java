import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Main {
    public static void main(String[] args) {
        String accessToken = "yourAccessTokenHere"; // Replace with your actual access token

        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<YourObjectType> response = rest.exchange(
            "http://localhost:8080/your-endpoint",
            HttpMethod.GET,
            entity,
            YourObjectType.class
        );

        YourObjectType responseBody = response.getBody();
        System.out.println(responseBody);
    }
}

class YourObjectType {
    // Define fields, getters, setters, and other methods here
}