import org.springframework.security.core.context.SecurityContextHolder;

public class Temp1485 {
    public static void main(String[] args) {
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}