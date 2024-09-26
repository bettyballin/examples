import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextUtil1 {
    public static void clearAuthentication() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }
    
    public static void main(String[] args) {
        clearAuthentication();
    }
}