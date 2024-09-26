import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp1797 {
    public static void main(String[] args) {
        // Mocking the Authentication object for demonstration purposes
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        if (auth != null) {
            System.out.println("Authentication object is not null");
            // Use 'auth' object for further processing
        } else {
            System.out.println("Authentication object is null");
        }
    }
}