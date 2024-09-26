import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Temp510 {
    public static void main(String[] args) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof UserDetails) {
                UserDetails user = (UserDetails) principal;
                System.out.println("User is logged in: " + user.getUsername());
                // Other details can be accessed from the 'user' object
            } else {
                System.out.println("Principal is not an instance of UserDetails");
            }
        } else {
            System.out.println("Authentication object is null");
        }
    }
}