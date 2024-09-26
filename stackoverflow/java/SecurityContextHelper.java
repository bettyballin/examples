import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextHelper {
    public static String getCurrentUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
    
    public static void main(String[] args) {
        System.out.println("Current user name: " + getCurrentUserName());
    }
}