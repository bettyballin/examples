import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.filter.OncePerRequestFilter;

public class CheckAfterLoginFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            filterChain.doFilter(request, response);
            return;
        }

        Boolean passwordExpired = (Boolean) session.getAttribute("password_expired");
        
        if (passwordExpired != null && passwordExpired.booleanValue()) {
            // Redirect to change password page
            response.sendRedirect(request.getContextPath() + "/change_password");
            return;
        }
        
        filterChain.doFilter(request, response);
    }
}