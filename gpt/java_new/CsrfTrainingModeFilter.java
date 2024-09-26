import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CsrfTrainingModeFilter extends OncePerRequestFilter {

    private CsrfFilter csrfFilter;

    public CsrfTrainingModeFilter(CsrfFilter csrfFilter) {
        this.csrfFilter = csrfFilter;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            csrfFilter.doFilter(request, response, filterChain);
        } catch (Exception e) {
            // Handle the exception for training mode
            // For example, log the exception and continue the filter chain
            // This is just a placeholder, replace with actual exception handling logic
            e.printStackTrace();
            filterChain.doFilter(request, response);
        }
    }
}