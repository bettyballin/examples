import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Temp792 implements javax.servlet.Filter {
    
    private String loginURI = "/login";
    private boolean securityRequest = true; // Assuming a value for example
    private boolean loggedIn = false; // Assuming a value for example

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        if (!securityRequest || loggedIn) {
            chain.doFilter(req, res);
        } else {
            response.sendRedirect(loginURI);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if necessary
    }

    @Override
    public void destroy() {
        // Cleanup code, if necessary
    }

    public static void main(String[] args) {
        // Main method is not typically used in a Filter, but included for completeness
        System.out.println("Temp792 Filter");
    }
}