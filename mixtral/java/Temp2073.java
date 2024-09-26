import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.HashMap;

@SpringBootApplication
public class Temp2073 {
    public static void main(String[] args) {
        SpringApplication.run(Temp2073.class, args);
    }
}

@RestController
class UserController {

    @GetMapping("/user")
    public Map<String, Object> user(@RegisteredOAuth2AuthorizedClient("google") OAuth2AuthorizedClient authorizedClient) {
        Map<String, Object> userInfo = new HashMap<>();
        // Assuming you'd use the authorizedClient to fetch user info from Google's API
        userInfo.put("clientName", authorizedClient.getClientRegistration().getClientName());
        userInfo.put("principalName", authorizedClient.getPrincipalName());
        // Additional user info can be fetched from the authorizedClient
        return userInfo;
    }
}