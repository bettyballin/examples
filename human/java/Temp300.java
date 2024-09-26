import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp300 {
    public static void main(String[] args) {
        // Example call to getPrincipal method
        Object principal = getPrincipal();
        System.out.println(principal);
    }

    public static Object getPrincipal() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth == null ? null : auth.getPrincipal();
    }
}