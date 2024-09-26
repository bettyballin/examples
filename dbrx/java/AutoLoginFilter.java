import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;

@Component
public class AutoLoginFilter extends OncePerRequestFilter {

    private final org.springframework.security.authentication.AuthenticationManager authenticationManager;

    public AutoLoginFilter(org.springframework.security.authentication.AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String username = request.getParameter("user");
        String password = request.getParameter("pass");

        if (username != null && password != null) {
            // Authenticate the user using Spring Security's authentication manager
            UsernamePasswordAuthenticationToken authRequest =
                    new UsernamePasswordAuthenticationToken(username, password);
            authRequest.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            Authentication authResult = authenticationManager.authenticate(authRequest);

            // Set security context and session attributes
            SecurityContextHolder.getContext().setAuthentication(authResult);
        }

        filterChain.doFilter(request, response);
    }
}