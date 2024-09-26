import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

public class Temp2630 {
    public static void main(String[] args) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String name = authentication.getName();
            System.out.println(name);
        } else {
            System.out.println("No authentication found.");
        }
    }
}