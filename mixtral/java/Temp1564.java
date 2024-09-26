import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp1564 {
    public static void main(String[] args) {
        setup();
    }

    public static void setup() {
        UsernamePasswordAuthenticationToken auth =
            new UsernamePasswordAuthenticationToken("user", "password");

        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}