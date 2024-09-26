import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String username = "your_username";
        String password = "your_password";
        int port = 8080;

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);

        HttpEntity<Void> requestEntity = new HttpEntity<>(null, headers);

        RestTemplate rest = new RestTemplate();
        ResponseEntity<List> response = rest.exchange(
            "http://localhost:" + port + "/employee",
            HttpMethod.GET,
            requestEntity,
            List.class
        );

        System.out.println(response.getBody());
    }
}