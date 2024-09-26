import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter extends OncePerRequestFilter {
    private static final ThreadLocal<String> REQUEST_SPECIFIC = new ThreadLocal<>();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Set the value
        String specificValue = "some-value";
        REQUEST_SPECIFIC.set(specificValue);

        try {
            filterChain.doFilter(request, response);
        } finally {
            // Clear after use
            REQUEST_SPECIFIC.remove();
        }
    }
}