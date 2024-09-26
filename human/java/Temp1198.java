import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp1198 {
    public static void main(String[] args) {
        SecurityContext securityContext = SecurityContextHolder.getContext(); 
        Authentication authentication = securityContext.getAuthentication();
        
        if (authentication != null) {
            System.out.println("Authentication object: " + authentication);
        } else {
            System.out.println("No authentication found.");
        }
    }
}