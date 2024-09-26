import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class CheckUserAuthentication {
    public static void main(String[] args) {
        RestTemplate rest = new RestTemplate();
        
        String username = "exampleUser"; // Replace with actual username
        String url = "http://server1.mydomain.com/isLoggedIn?username=" + URLEncoder.encode(username, StandardCharsets.UTF_8);
        
        ResponseEntity<Boolean> response = rest.getForEntity(url, Boolean.class);
        boolean isUserAuthenticated = response.getBody();
        
        System.out.println("Is user authenticated: " + isUserAuthenticated);
    }
}