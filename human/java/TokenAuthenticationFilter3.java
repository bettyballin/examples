import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

@Component
public class TokenAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) req;
        // Here, I get the token from authorization header, change if you get it from anywhere else
        String token = httpRequest.getHeader("Authorization");

        // here i'm just doing a dummy check. if my token equals "mysupersecrettoken" the authentication is validated
        // change this test by yours (using Auth0 etc.)
        if ("mysupersecrettoken".equals(token)) {
            // dummy authentication object. You can set a real username / credentials / role based on the claims of your token if you want to.
            UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken("username", "credentials",
                    Arrays.asList(new SimpleGrantedAuthority("ROLE")));
            SecurityContextHolder.getContext().setAuthentication(user);
        }
        // call next filters, if authentication is not valid, no authentication will be set so user will not be authenticated
        chain.doFilter(req, res);
    }
}