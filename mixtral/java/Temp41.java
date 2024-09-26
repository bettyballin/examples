import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;

public class Temp41 {
    public static void main(String[] args) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAuthenticated = (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)
                && authentication.isAuthenticated());

        if (isAuthenticated) {
            // User already logged in
            System.out.println("User is authenticated.");
        } else {
            // No user currently authenticated
            System.out.println("No user is authenticated.");
        }
    }
}