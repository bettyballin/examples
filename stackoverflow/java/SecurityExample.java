import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityExample {
    public static void main(String[] args) {
        SecurityContext secureContext = SecurityContextHolder.getContext();
        Authentication auth = secureContext.getAuthentication();
        Object principal = auth.getPrincipal();

        String userName;
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }

        System.out.println("Username: " + userName);
    }
}