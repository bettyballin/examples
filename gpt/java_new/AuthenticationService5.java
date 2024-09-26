import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationService5 {

    private final RestTemplate restTemplate;

    @Autowired
    public AuthenticationService5(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String authenticationService(String username, String password) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        return restTemplate.getForObject("http://localhost:8080/", String.class, headers);
    }
}