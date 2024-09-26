import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFilter3 extends OncePerRequestFilter {
    private BasicAuthenticationFilter basicAuthFilter;
    private SsoAuthenticationFilter ssoAuthFilter;

    public CustomAuthenticationFilter3(BasicAuthenticationFilter basicAuthFilter, SsoAuthenticationFilter ssoAuthFilter) {
        this.basicAuthFilter = basicAuthFilter;
        this.ssoAuthFilter = ssoAuthFilter;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String ppauthToken = request.getHeader("ppauth");
        String authorizationHeader = request.getHeader("Authorization");

        if (ppauthToken != null) {
            ssoAuthFilter.doFilter(request, response, filterChain);
        } else if (authorizationHeader != null && authorizationHeader.startsWith("Basic ")) {
            basicAuthFilter.doFilter(request, response, filterChain);
        } else {
            filterChain.doFilter(request, response);
        }
    }
}