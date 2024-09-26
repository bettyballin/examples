import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Component
public static class TokenEventListener implements ApplicationListener<AuthorizationServerTokenServicesCreateEvent> {

    @Override
    public void onApplicationEvent(AuthorizationServerTokenServicesCreateEvent event) {
        // Your code here

        OAuth2AccessToken accessToken = event.getAccessToken();

        System.out.println("New Access Token: " + accessToken);

        // ...

    }
}

// Mock class to represent the event class
class AuthorizationServerTokenServicesCreateEvent {
    private OAuth2AccessToken accessToken;

    public AuthorizationServerTokenServicesCreateEvent(OAuth2AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public OAuth2AccessToken getAccessToken() {
        return accessToken;
    }
}

// Mock class for OAuth2AccessToken
class OAuth2AccessToken {
    private String token;

    public OAuth2AccessToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return token;
    }
}

// Test the listener
public class TestTokenEventListener {
    public static void main(String[] args) {
        TokenEventListener listener = new TokenEventListener();
        OAuth2AccessToken token = new OAuth2AccessToken("sample-token");
        AuthorizationServerTokenServicesCreateEvent event = new AuthorizationServerTokenServicesCreateEvent(token);
        listener.onApplicationEvent(event);
    }
}