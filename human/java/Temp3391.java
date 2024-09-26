import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;

public class Temp3391 implements AuthenticationProvider {
    public static void main(String[] args) {
        // Example usage
        Temp3391 authProvider = new Temp3391();
        Authentication auth = new UsernamePasswordAuthenticationToken("user@example.com", "password");
        try {
            Authentication result = authProvider.authenticate(auth);
            System.out.println("Authentication successful: " + result);
        } catch (AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var email = authentication.getName();
        var password = authentication.getCredentials().toString();
        // Call here to backend to check login
        return new UsernamePasswordAuthenticationToken(email, password);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}