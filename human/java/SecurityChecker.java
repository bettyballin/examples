import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityChecker {

    public static boolean isSecured() {
        return SecurityContextHolder.getContext().getAuthentication() != null;
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println("Is secured: " + isSecured());
    }
}