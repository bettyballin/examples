import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        String username = obtainUsername(req);
        String password = obtainPassword(req);
        // Extract location parameter
        String location = req.getParameter("location");

        return getAuthenticationManager().authenticate(new CustomAuthToken(username, password, location));
    }
}

class CustomAuthToken extends AbstractAuthenticationToken {

    private final Object principal;
    private final Object credentials;
    private final String location;

    public CustomAuthToken(Object principal, Object credentials, String location) {
        super((Collection<?>) null);
        this.principal = principal;
        this.credentials = credentials;
        this.location = location;
        setAuthenticated(false);
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    public String getLocation() {
        return this.location;
    }

    // Implement other methods if necessary
}

class ApiAuthenticationProvider implements AuthenticationProvider {

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthToken.class.isAssignableFrom(authentication);
    }

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        // Handle your custom token here
        if (auth instanceof CustomAuthToken) {
            CustomAuthToken customAuthToken = (CustomAuthToken) auth;
            String username = (String) customAuthToken.getPrincipal();
            String password = (String) customAuthToken.getCredentials();
            String location = customAuthToken.getLocation();

            // Implement your authentication logic here
            // For now, just return an authenticated token if the username and password match
            if ("user".equals(username) && "password".equals(password)) {
                return new UsernamePasswordAuthenticationToken(username, password, null);
            }
        }

        throw new AuthenticationException("Authentication failed") {};
    }
}