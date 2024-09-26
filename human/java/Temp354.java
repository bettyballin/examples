import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Temp354 {
    public static void main(String[] args) {
        SecurityContext secureContext = SecurityContextHolder.getContext();
        Authentication auth = secureContext.getAuthentication();
        Object principal = auth.getPrincipal();

        String userName = null;
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            userName = userDetails.getUsername();
        } else {
            userName = principal.toString();
        }

        System.out.println("Username: " + userName);
    }
}