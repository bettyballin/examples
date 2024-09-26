import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityChecker {

    public static boolean isSecured() {
        return SecurityContextHolder.getContext().getAuthentication() != null;
    }
}