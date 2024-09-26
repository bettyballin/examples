import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class CustomFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) 
            throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication != null) {
            boolean isValidUser = checkIfValidUser(authentication);
            if (isValidUser) {
                chain.doFilter(request, response);  // Proceed with further filters or request handling
            } else {
                throw new ServletException("Invalid User");
            }
        } else {
            throw new ServletException("Authentication is null");
        }
    }

    private boolean checkIfValidUser(Authentication authentication) {
        try {
            String username = authentication.getName();
            // Check in DB if the user is present and has a special property.
            // Add your database logic here
            return true;  // Return false for invalid users
        } catch (Exception e) {
            return false;
        }
    } 
}