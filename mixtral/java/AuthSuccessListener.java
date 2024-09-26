import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUserInfo;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class AuthSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        Authentication authentication = event.getAuthentication();

        if (authentication instanceof OAuth2AuthenticationToken) {
            Object details = authentication.getDetails();

            // Check the type before casting
            if (details instanceof BearerTokenAuthenticationToken) {
                String accessToken = ((BearerTokenAuthenticationToken) details).getToken();

                System.out.println("access token: " + accessToken);

                // Do something with the access token

            } else if (details instanceof OidcUserInfo) {

                String id_token = ((OidcUserInfo) details).getClaims().get("id_token").toString();

                System.out.println("ID Token: " + id_token);

                // Do something with the ID token
            }
        }
    }
}