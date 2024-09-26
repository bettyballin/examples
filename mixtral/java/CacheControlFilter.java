import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CacheControlFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        // Customize cache control headers based on your conditions

        if (/* some condition */) {
            response.setHeader("Cache-Control", "max-age=60");
        } else {
            response.setHeader("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate");
        }

        chain.doFilter(request, response);
    }
}