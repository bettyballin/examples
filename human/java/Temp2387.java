import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

public class Temp2387 {
    public static void main(String[] args) {
        // Assuming the security context and authentication are already set up
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            System.out.println("Authentication: " + authentication);
        } else {
            System.out.println("No authentication information available.");
        }
    }
}