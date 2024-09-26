import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

public class Temp3471 {
    public static void main(String[] args) {
        // Assuming that the SecurityContextHolder has been properly set up elsewhere in your application
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            System.out.println("Authentication: " + authentication);
        } else {
            System.out.println("No authentication details available.");
        }
    }
}