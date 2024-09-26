import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreInvocationAuthorizationAdviceVoter;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp1166 {
    public static void main(String[] args) {
        Temp1166 temp = new Temp1166();
        // Example call (this will not actually work without a proper Spring context)
        // User user = temp.getUser(1L);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission(#id, 'read')")
    public User getUser(Long id) {
        // Your logic here...
        User user = new User(); // Placeholder for actual user fetching logic
        return user;
    }
}

class User {
    // Define user properties and methods here
}