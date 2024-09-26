import java.util.Collection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp1710 {
    public static void main(String[] args) {
        // Simulate setting an authentication object for demonstration purposes
        // In a real application, this would be managed by Spring Security
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication != null) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            // Print authorities for demonstration purposes
            authorities.forEach(authority -> System.out.println(authority.getAuthority()));
        } else {
            System.out.println("No authentication found.");
        }
    }
}