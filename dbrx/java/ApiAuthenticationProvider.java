import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;

@Component
@RequestScope
public class ApiAuthenticationProvider implements AuthenticationProvider {
    private final HttpServletRequest request;

    public ApiAuthenticationProvider(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Implement your authentication logic here
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // Specify the type of authentication this provider supports
        return true;
    }
}