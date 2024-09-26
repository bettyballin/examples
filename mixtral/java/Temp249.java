import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Temp249 {

    public static void main(String[] args) {
        // Main method not typically used in servlet filters
    }

    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        boolean isUserAuthenticated = checkUserAuthentication(request);

        if (!isUserAuthenticated) {
            response.sendRedirect("/login");
            return;
        }

        chain.doFilter(request, response);
    }

    private boolean checkUserAuthentication(HttpServletRequest request) {
        // Placeholder authentication check
        // Replace with actual authentication logic
        return false;
    }
}