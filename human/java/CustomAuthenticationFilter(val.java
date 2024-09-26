import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class CustomAuthenticationFilter extends OncePerRequestFilter {
    private final AuthenticationManager authManager;

    public CustomAuthenticationFilter(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException {
        String username = request.getHeader("foo_username");
        String password = request.getHeader("foo_password");

        try {
            if (username == null && password == null) {
                // not our responsibility. delegate down the chain. maybe a different filter will understand this request.
                chain.doFilter(request, response);
                return;
            } else if (username == null || password == null) {
                // user is clearly trying to authenticate against the CustomAuthenticationFilter, but has done something wrong.
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            // construct one of Spring's auth tokens
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
            // delegate checking the validity of that token to our authManager
            var userPassAuth = this.authManager.authenticate(authRequest);
            // store completed authentication in security context
            SecurityContextHolder.getContext().setAuthentication(userPassAuth);
            // continue down the chain.
            chain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}