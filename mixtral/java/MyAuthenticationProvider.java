import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    private final KeycloakAdapter keycloakAdapter;

    public MyAuthenticationProvider(KeycloakAdapter keycloakAdapter) {
        this.keycloakAdapter = keycloakAdapter;
    }

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        // Delegate to Keycloak's adapter for actual JWT validation and user details retrieval
        var keycloakAuth = (KeycloakAuthenticationToken) auth;

        if (!keycloakAdapter.validateToken(auth)) {
            throw new BadCredentialsException("Invalid token");
        }

        // Extract required information from KeycloakPrincipal
        CustomObject customObj = extractCustomDetailsFromKeycloakUserInfo(keycloakAuth);

        return new UsernamePasswordAuthenticationToken(customObj, null);
    }

    @Override
    public boolean supports(Class<?> auth) {
        // Only support Keycloak's authentication token
        return KeycloakAuthenticationToken.class.isAssignableFrom(auth);
    }

    private CustomObject extractCustomDetailsFromKeycloakUserInfo(KeycloakAuthenticationToken keycloakAuth) {
        // Implement the logic to extract custom details from Keycloak user info
        return new CustomObject();
    }
}

// Dummy classes for illustration purposes
class KeycloakAdapter {
    public boolean validateToken(Authentication auth) {
        // Implement token validation logic here
        return true;
    }
}

class CustomObject {
    // Define fields and methods for the custom object
}