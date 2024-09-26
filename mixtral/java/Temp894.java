import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Temp894 implements Filter {
    public static void main(String[] args) {
        // Main method is not typically used in a servlet/filter, but added here for completeness
        System.out.println("Temp894 Filter Example");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpResp = (HttpServletResponse) response;

        boolean secureFlagValue = getSecureFlagFromConfig(); // Implement this method to retrieve the flag value from your configuration.

        Cookie cookieToSet = new Cookie("cookieName", "cookieValue");

        if (secureFlagValue) {
            cookieToSet.setSecure(true);
        } else {
            cookieToSet.setSecure(false);
        }

        httpResp.addCookie(cookieToSet);

        chain.doFilter(request, response);
    }

    private boolean getSecureFlagFromConfig() {
        // Dummy implementation, replace with actual configuration retrieval logic
        return true; // or false based on your configuration
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}