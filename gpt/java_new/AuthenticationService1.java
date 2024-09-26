import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthenticationService1 {
    public void changeUsername(String newUsername) {
        Authentication currentAuth = SecurityContextHolder.getContext().getAuthentication();
        
        Authentication newAuth = new UsernamePasswordAuthenticationToken(
            newUsername,
            currentAuth.getCredentials(),
            currentAuth.getAuthorities()
        );
        
        SecurityContextHolder.getContext().setAuthentication(newAuth);
    }
}