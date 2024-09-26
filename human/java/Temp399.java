import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import java.util.Collections;

public class Temp399 {
    public static void main(String[] args) {
        // Example user details
        String username = "user";
        String password = "password";
        
        // Create an authentication token
        Authentication auth = new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList());
        
        // Set the authentication in the security context
        SecurityContextHolder.getContext().setAuthentication(auth);

        // Print to verify
        System.out.println("Authentication set in SecurityContextHolder: " + SecurityContextHolder.getContext().getAuthentication());
    }
}