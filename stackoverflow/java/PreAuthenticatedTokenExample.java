import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;

public class PreAuthenticatedTokenExample {
    public void createPreAuthenticatedToken() {
        Object p = null; // Replace with a valid principal object
        PreAuthenticatedAuthenticationToken token = new PreAuthenticatedAuthenticationToken(
                p, null, AuthorityUtils.NO_AUTHORITIES);
        // ... use the token as needed
    }
}