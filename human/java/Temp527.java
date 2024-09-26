import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp527 {
    public static void main(String[] args) {
        Authentication authentication = new UsernamePasswordAuthenticationToken("dummy", "password");
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);

        System.out.println("Authentication set for user: " + securityContext.getAuthentication().getName());
    }
}