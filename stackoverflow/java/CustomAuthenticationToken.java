import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {
    // Assuming additional fields, constructors, and methods should be here

    public CustomAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public CustomAuthenticationToken(Object principal, Object credentials, Collection<?> authorities) {
        super(principal, credentials, authorities);
    }

    // Additional methods or overrides can be placed here
}