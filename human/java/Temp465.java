import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;

public class Temp465 implements javax.servlet.Filter {
    private String rolePrefix = "ROLE_";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        chain.doFilter(new SecurityContextHolderAwareRequestWrapper(
                (HttpServletRequest) req, rolePrefix), res);
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }

    public static void main(String[] args) {
        // Main method, if needed
    }
}