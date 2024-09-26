import javax.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import javax.servlet.http.HttpServletRequest;

public class Temp1134 {
    public static void main(String[] args) {
        // This is a placeholder for demonstration purposes.
        // In a real application, you would obtain the request and session from the web context.
        HttpServletRequest request = getRequest();

        // Clear security context
        SecurityContextHolder.clearContext();

        // Invalidate httpSession
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Remove SecurityContext from thread local
        request.removeAttribute("SPRING_SECURITY_CONTEXT");
    }

    // Dummy method to simulate obtaining HttpServletRequest
    private static HttpServletRequest getRequest() {
        // This would be replaced with real code to get the current HttpServletRequest
        return null;
    }
}