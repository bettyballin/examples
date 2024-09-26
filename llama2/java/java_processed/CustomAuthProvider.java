import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Perform IP address check here
        if (!isAuthorizedIpAddress(authentication.getPrincipal())) {
            throw new AuthenticationException("Unauthorized IP address") {};
        }

        // Continue with the rest of the authentication process
        // Custom logic for authentication should be placed here
        
        // Assuming authentication is successful
        return authentication;
    }

    private boolean isAuthorizedIpAddress(Object principal) {
        // Check if the user's IP address is in the database
        // or perform any other custom checks you want
        return true;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return AbstractAuthenticationToken.class.isAssignableFrom(authentication);
    }
}