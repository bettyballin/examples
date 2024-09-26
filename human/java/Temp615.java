import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

public class Temp615 {
    public static void main(String[] args) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            System.out.println("Authentication: " + authentication);
        } else {
            System.out.println("No authentication information available.");
        }
    }
}