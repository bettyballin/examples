import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;

public class IgnoreFailuresBasicAuthenticationFilter extends BasicAuthenticationFilter {
    private final BasicAuthenticationFilter everythingElse;

    public IgnoreFailuresBasicAuthenticationFilter(BasicAuthenticationFilter everythingElse) {
        super(everythingElse.getAuthenticationManager());
        this.everythingElse = everythingElse;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if ("/api/v1/notification".equals(request.getPathInfo())) {
            super.doFilterInternal(request, response, chain);
        } else {
            this.everythingElse.doFilter(request, response, chain);
        }
    }
}