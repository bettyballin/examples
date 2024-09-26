import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils4 {
    public static void main(String[] args) {
        SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }
}