import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class HstsFilter implements Filter {

    public void init(FilterConfig fConfig) {
        // Filter initialization if needed
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (response instanceof HttpServletResponse) {
            HttpServletResponse res = (HttpServletResponse) response;
            // max-age is 6 months (15768000 seconds)
            res.setHeader("Strict-Transport-Security", "max-age=15768000; includeSubDomains");
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
        // Filter destruction if needed
    }
}