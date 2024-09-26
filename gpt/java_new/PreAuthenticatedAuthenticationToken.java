import org.springframework.security.authentication.AbstractAuthenticationToken;
import javax.servlet.http.HttpServletRequest;

public class PreAuthenticatedAuthenticationToken extends AbstractAuthenticationToken {
    private static final long serialVersionUID = 1L;
    private final Object principal;

    public PreAuthenticatedAuthenticationToken(Object principal) {
        super(null);
        this.principal = principal;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }
}

class User {}

class SessionAuthentication {
    private void authenticateUserAndSetSession(HttpServletRequest request, User user) {
        PreAuthenticatedAuthenticationToken token = new PreAuthenticatedAuthenticationToken(user);
        // Assuming there is code here to set the user session
    }
}