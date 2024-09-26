import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils7 {
    public static Object getPrincipal() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}