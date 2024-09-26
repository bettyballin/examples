import org.springframework.security.core.context.SecurityContextHolder;

public class Temp252 {
    public static void main(String[] args) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("Authenticated user: " + userName);
    }
}