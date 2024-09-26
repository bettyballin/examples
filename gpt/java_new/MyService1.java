import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collections;

public class MyService1 {

    @PreAuthorize("hasAnyRole('MY_USER_ROLE', 'ROLE_SYSTEM')")
    public void myServiceMethod() {
        // ... method implementation
    }
    
    // Example usage
    public void authenticate() {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
            "systemuser", 
            null, 
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_SYSTEM"))
        );
        
        // Use the authentication object as needed
    }
}