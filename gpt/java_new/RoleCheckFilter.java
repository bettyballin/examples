import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class RoleCheckFilter implements Filter {

    public void init(FilterConfig filterConfig) {
        // Filter initialization, if needed
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // Assuming we check for an "admin" role
        if (req.isUserInRole("admin")) {
            chain.doFilter(request, response);
        } else {
            res.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }

    public void destroy() {
        // Filter cleanup, if needed
    }
}