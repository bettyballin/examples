import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import javax.servlet.http.HttpServletRequest;

public class CustomTokenAuthentication extends PreAuthenticatedAuthenticationToken {

    public CustomTokenAuthentication(String token) {
        super(token, null);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.getPrincipal();
    }

    public static Authentication getPreAuthenticatedPrincipal(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Custom ")) {
            return new CustomTokenAuthentication(authorization.substring(7));
        }
        return null;
    }
}