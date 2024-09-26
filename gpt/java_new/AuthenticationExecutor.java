import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationExecutor {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationExecutor(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public void executeAsAuthenticatedUser(String username, String password, Runnable task) {
        Authentication originalAuth = SecurityContextHolder.getContext().getAuthentication();
        try {
            UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(username, password);
            Authentication auth = authenticationManager.authenticate(authReq);
            SecurityContextHolder.getContext().setAuthentication(auth);
            task.run();
        } finally {
            SecurityContextHolder.getContext().setAuthentication(originalAuth);
        }
    }
}