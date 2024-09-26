import org.springframework.security.core.context.SecurityContextHolder;

public class Temp1161 {
    public static void main(String[] args) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principal);
    }
}