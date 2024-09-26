import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils1 {
    public static Object getPrincipal() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    
    public static void main(String[] args) {
        // Usage example
        Object principal = getPrincipal();
        // Now you can cast the principal to your desired type, like UserDetails or a custom user object.
    }
}