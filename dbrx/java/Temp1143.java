import org.springframework.web.client.RestTemplate;
import java.net.URI;

public class Temp1143 {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            URI uri = restTemplate.postForLocation(callService("service1", "/other-service2/message"), "Message", String.class);
            String response = uri.toString();
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String callService(String service, String endpoint) {
        // Assuming a base URL for the service, you can modify it according to your requirements
        String baseUrl = "http://localhost:8080/";
        return baseUrl + service + endpoint;
    }
}