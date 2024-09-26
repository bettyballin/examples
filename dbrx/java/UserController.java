import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/me")
    public Mono<User> getCurrentUser(@RegisteredOAuth2AuthorizedClient("your-client-id") OAuth2AuthorizedClient authorizedClient, Authentication authentication) {
        String accessToken = authorizedClient.getAccessToken().getTokenValue();
        return userService.getUserInfo(accessToken);
    }
}

class User {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface UserService {
    Mono<User> getUserInfo(String accessToken);
}