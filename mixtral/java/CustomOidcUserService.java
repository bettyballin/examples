import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUserRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomOidcUserService implements OAuth2UserService<OidcUserRequest, OidcUser> {

    @Override
    public OidcUser loadUser(OidcUserRequest oidcUserRequest) throws OAuth2AuthenticationException {
        // Extract email from the user info
        String email = (String) oidcUserRequest.getIdToken().getClaims().get("email");

        // Load your custom UserDetails based on this email
        // Here you would have your custom logic to load user details

        // For demonstration purposes, returning null
        // Replace with your actual implementation
        return null;
    }
}