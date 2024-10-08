import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthorityUtils {

    @Autowired
    private AuthenticationManager authenticationManager;

    public void loginDirectly(String email, String password) {
        UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken(email, password);
        Authentication authenticatedUser = authenticationManager.authenticate(loginToken);
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }
}