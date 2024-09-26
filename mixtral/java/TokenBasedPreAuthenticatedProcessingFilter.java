import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class TokenBasedPreAuthenticatedProcessingFilter extends AbstractPreAuthenticatedProcessingFilter {

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        String token = request.getParameter("token");

        if (isValidToken(token)) {
            return new UsernamePasswordAuthenticationToken(
                    "preauthuser", null, Arrays.asList(new SimpleGrantedAuthority("ROLE_PREAUTH")));
        }

        throw new AuthenticationCredentialsNotFoundException("Invalid token");
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return "N/A";
    }

    private boolean isValidToken(String token) {
        // Implement your token validation logic here
        return token != null && !token.isEmpty();
    }
}