import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;

public class Temp501 {
    public static void main(String[] args) {
        // Sample invocation (for demonstration purposes)
        HttpServletRequest request = null; // Should be replaced with actual request object
        HttpServletResponse response = null; // Should be replaced with actual response object
        Authentication auth = null; // Should be replaced with actual authentication object
        new Temp501().onAuthentication(auth, request, response);
    }

    public void onAuthentication(Authentication auth, HttpServletRequest request, HttpServletResponse response) {
        // Check if there's an existing authenticated principal for current user.
        Authentication existingAuth = SecurityContextHolder.getContext().getAuthentication();
        if (existingAuth != null) {
            Object previousPrincipal = existingAuth.getPrincipal();
            if (previousPrincipal != null && !auth.getPrincipal().equals(previousPrincipal)) {
                // If so invalidate the session and force a new one to be created
                request.getSession().invalidate();
                request.getSession(true);
            }
        }
    }
}