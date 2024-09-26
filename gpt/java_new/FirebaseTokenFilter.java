import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class FirebaseTokenFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        if (!httpRequest.getRequestURI().equals("/registerUser")) {
            String tokenHeader = httpRequest.getHeader("Firebase-Token");

            if (!validateToken(tokenHeader)) {
                throw new ServletException("Invalid Firebase Token");
            }
        }

        chain.doFilter(request, response);
    }

    private boolean validateToken(String tokenHeader) {
        // Token validation logic here
        return true; // Replace with actual validation
    }

    @Override
    public void destroy() {
        // Cleanup code if needed
    }
}