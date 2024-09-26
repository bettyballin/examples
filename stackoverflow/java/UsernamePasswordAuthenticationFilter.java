import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.authentication.AuthenticationServiceException;

public class UsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    
    private boolean postOnly = true;
    private String usernameParameter = "username";
    private String passwordParameter = "password";
    
    // Constructor to set the default filter processes URL
    public UsernamePasswordAuthenticationFilter() {
        super("/login");
    }

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }

        String username = obtainUsername(request);
        String password = obtainPassword(request);

        // Rest of the authentication logic would be here...

        return null; // Replace with actual authentication result
    }

    protected String obtainPassword(HttpServletRequest request) {
        return request.getParameter(passwordParameter);
    }

    protected String obtainUsername(HttpServletRequest request) {
        return request.getParameter(usernameParameter);
    }

    // Additional methods and properties might be required for the actual filter to function
}