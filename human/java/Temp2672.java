import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Temp2672 {
    public static void main(String[] args) {
        Temp2672 temp = new Temp2672();
        String id = "exampleUser"; // Example ID for testing
        temp.someMethod(id);
    }

    @PreAuthorize("hasRole('ROLE_VIEWER') or hasRole('ROLE_EDITOR') or #id == authentication.principal.username")
    public void someMethod(String id) {
        System.out.println("Access granted for ID: " + id);
    }

    // Mock setup for Spring Security context (for testing purposes)
    static {
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
        SecurityContextHolder.getContext().setAuthentication(
            new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                new org.springframework.security.core.userdetails.User(
                    "exampleUser", "password", java.util.Collections.emptyList()
                ), null
            )
        );
    }
}