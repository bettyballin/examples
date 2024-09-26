import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class RestTemplateExample {
    public static void main(String[] args) {
        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("username", "password");

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<YourObjectType> response = rest.exchange(
            "http://localhost:8080/your-endpoint",
            HttpMethod.GET,
            entity,
            YourObjectType.class
        );

        // Assuming YourObjectType has a proper toString method
        System.out.println(response.getBody());
    }
}

class YourObjectType {
    // Define fields, constructors, getters, and setters here
}