import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Filter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class Temp2425 extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        if (request.getServletPath().equals("/auth/login")) {
            // If the endpoint is /auth/login skip this filter and continue with other filters
            System.out.println("Skipping JwtAuthenticationFilter for login request");
            filterChain.doFilter(request, response);
        } else {
            // Otherwise proceed to check JWT token

            boolean tokenIsValid = checkToken(request);

            if (tokenIsValid) {
                // If the token is valid continue with other filters
                System.out.println("JwtAuthenticationFilter: Token is valid");
                filterChain.doFilter(request, response);
            } else {
                // Otherwise send an error message
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Token");
            }
        }
    }

    private boolean checkToken(HttpServletRequest request) {
        // Simulate token checking logic here
        String token = request.getHeader("Authorization");
        return token != null && token.equals("valid-token");
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization if needed
    }

    @Override
    public void destroy() {
        // Cleanup if needed
    }

    public static void main(String[] args) {
        // Main method if needed for any testing or standalone execution
    }
}