import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public class Temp1519 {
    public static void main(String[] args) {
        // Assuming Spring Security context is properly set up
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            System.out.println("User Details: " + userDetails);
        } else {
            System.out.println("No authentication details found.");
        }
    }
}