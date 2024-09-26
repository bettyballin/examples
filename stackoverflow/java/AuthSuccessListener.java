import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {

    private final TokenStore tokenStore;

    public AuthSuccessListener(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();
        List<OAuth2AccessToken> tokens = tokenStore.findTokensByClientIdAndUserName("your Client Id", userDetails.getUsername());
        if (!tokens.isEmpty()) {
            String accessToken = tokens.get(0).getValue();
        }
    }
}