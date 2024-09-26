import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthFilter extends AbstractAuthenticationProcessingFilter {

    public CustomAuthFilter(RequestMatcher requiresAuth) {
        super(requiresAuth);
    }

    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        return true; // Always require authentication
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest,
                                                HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

        String username = httpServletRequest.getHeader("foo_username");
        String password = httpServletRequest.getHeader("foo_password");

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
            throw new BadCredentialsException("Missing credentials.");

        UsernamePasswordAuthenticationToken authReq
                = new UsernamePasswordAuthenticationToken(username, password);

        return this.getAuthenticationManager().authenticate(authReq);
    }
}