import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class CustomAuthenticationFilter2 extends OncePerRequestFilter {

    private final AuthenticationManager authManager;

    public CustomAuthenticationFilter2(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String username = request.getHeader("foo_username");
        String password = request.getHeader("foo_password");

        if (username == null && password == null) {
            chain.doFilter(request, response);
            return;
        } else if (username == null || password == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
        UsernamePasswordAuthenticationToken userPassAuth = (UsernamePasswordAuthenticationToken)
                this.authManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(userPassAuth);
        chain.doFilter(request, response);
    }
}