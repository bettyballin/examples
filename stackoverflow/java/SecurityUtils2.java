import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import your.package.CustomUser; // Replace with the actual package name where CustomUser is located

public class SecurityUtils2 {
    public static CustomUser getAuthenticatedUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        return (CustomUser) auth.getPrincipal();
    }
}