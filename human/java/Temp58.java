import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

public class Temp58 {
    public static void main(String[] args) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            System.out.println("Principal: " + principal);
        } else {
            System.out.println("No authentication information available.");
        }
    }
}