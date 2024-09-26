import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    @Autowired
    private UserService userService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2AccessToken token = super.loadUser(userRequest).getAttribute("token");
        // Load the user from the database using the token
        User user = userService.loadUserByUsername(token.getTokenValue());

        // Create a new OAuth2User instance with the custom User class
        return new CustomOAuth2User(user, token);
    }
}

// Assuming you have the following classes

class User {
    private String username;
    // other fields and methods
    public String getUsername() {
        return username;
    }
}

class CustomOAuth2User implements OAuth2User {
    private User user;
    private OAuth2AccessToken token;

    public CustomOAuth2User(User user, OAuth2AccessToken token) {
        this.user = user;
        this.token = token;
    }

    @Override
    public Map<String, Object> getAttributes() {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("username", user.getUsername());
        // Implement method to return user attributes
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Implement method to return user authorities
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getName() {
        // Implement method to return user name
        return user.getUsername();
    }
}

interface UserService {
    User loadUserByUsername(String username);
}