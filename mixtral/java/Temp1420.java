import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Temp1420 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();

        if (session != null && !session.isNew() && !(servletRequest instanceof SavedRequestAwareWrapper)) {

            // If the user's session has timed out redirect to login page
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            HttpServletRequest request = (HttpServletRequest) servletRequest;

            String contextPath = request.getContextPath();

            if (!contextPath.endsWith("/"))
                contextPath += "/";

            // Redirect the user
            response.sendRedirect(response.encodeRedirectURL(request.getRequestURI().startsWith(contextPath) ?
                    request.getRequestURI() :
                    contextPath + request.getServletPath()));

        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }

    public static void main(String[] args) {
        // Main method, if needed for testing
    }
}