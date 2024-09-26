import org.springframework.security.core.context.SecurityContextHolder;

public class Temp124 {
    public static void main(String[] args) {
        // Assuming the security context is already set up with an authentication object
        // This is typically done in a web application context with Spring Security
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("Authenticated user: " + userName);
    }
}