import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

public class Temp410 {
    public static void main(String[] args) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            System.out.println("Authentication name: " + authentication.getName());
        } else {
            System.out.println("No authentication found.");
        }
    }
}