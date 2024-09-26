import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CustomUnauthRequestProcessingFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (isPermittedUrl(request)) {
            // Handle unauthenticated requests here
            return;
        }

        filterChain.doFilter(request, response);
    }

    private boolean isPermittedUrl(HttpServletRequest request) {
        String uri = request.getRequestURI();

        if (uri.startsWith("/v1/users")) {
            // ... other permitted URLs
            return true;
        }

        return false;
    }
}