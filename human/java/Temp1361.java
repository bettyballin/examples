import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationToken;

public class Temp1361 {
    public static void main(String[] args) {
        // Assuming we have an Authentication object
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        // Check if the authentication is a remember-me authentication
        boolean isRememberMe = isRememberMe(authentication);
        
        System.out.println("Is Remember Me: " + isRememberMe);
    }

    public static boolean isRememberMe(Authentication authentication) {
        return authentication != null && authentication instanceof RememberMeAuthenticationToken;
    }
}