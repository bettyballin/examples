import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import java.util.Collections;

public class SecurityContextExample {

    public void runAsRole() {
        // Save the original security context
        SecurityContext originalContext = SecurityContextHolder.getContext();

        try {
            // Create an authentication object with the required role
            Authentication runAsAuth = new UsernamePasswordAuthenticationToken(
                "runAsUser", null, Collections.singletonList(new SimpleGrantedAuthority("ROLE_YOUR_ROLE"))
            );

            // Set the new authentication in the security context
            SecurityContextHolder.getContext().setAuthentication(runAsAuth);

            // Your logic here, running with the privileges of "ROLE_YOUR_ROLE"

        } finally {
            // Restore the original security context
            SecurityContextHolder.setContext(originalContext);
        }
    }
}