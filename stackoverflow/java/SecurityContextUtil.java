import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextUtil {
    public static String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public static void main(String[] args) {
        System.out.println(getCurrentUsername());
    }
}