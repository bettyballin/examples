import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp1528 {
    public static void main(String[] args) {
        // Assuming Spring Security context is already set up in the application
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            System.out.println("User authenticated: " + auth.getName());
        } else {
            System.out.println("No authentication information available.");
        }
    }
}