import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {

    private final AuthService authService;
    private final String securedEndpointPattern;

    @Autowired
    public AuthTokenFilter(AuthService authService, String securedEndpointPattern) {
        this.authService = authService;
        this.securedEndpointPattern = securedEndpointPattern;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Perform authentication here using authService

        // Continue the filter chain
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !new AntPathRequestMatcher(this.securedEndpointPattern).matches(request);
    }
}

@Component
class AuthService {
    // Authentication logic
}

@Configuration
class FilterConfig {

    @Bean
    public AuthTokenFilter authenticationTokenFilterBean(AuthService authService) {
        return new AuthTokenFilter(authService, "/api/**");
    }
}