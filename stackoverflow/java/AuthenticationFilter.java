import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.FilterChain;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import javax.servlet.ServletException;

public class AuthenticationFilter extends OncePerRequestFilter {
    private final RequestMatcher ignoredPaths = new AntPathRequestMatcher("/swagger-ui/**");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (this.ignoredPaths.matches(request)) { 
            filterChain.doFilter(request, response);
            return;
        }

        // do your logic
        filterChain.doFilter(request, response);
    }
}