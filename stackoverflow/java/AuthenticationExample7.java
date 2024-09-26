import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthenticationExample7 {
    public static void main(String[] args) {
        // Example usage of UsernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken("user", "password");
        
        // Further processing of the authenticationToken...
    }
}