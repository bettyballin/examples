import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SessionValidationInterceptor implements HandlerInterceptor {

    @Autowired
    private YourSessionService yourSessionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            String sessionIdClaim = extractSessionIdClaim(authentication); // Implement this method to extract your claim from the JWT

            boolean isSessionActive = yourSessionService.validate(sessionIdClaim);

            if (!isSessionActive) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or expired session");
                return false;
            }
        }

        // continue with request processing
        return true;
    }

    private String extractSessionIdClaim(Authentication authentication) {
        // Implement your logic to extract the sessionIdClaim from the JWT
        return "extractedSessionIdClaim"; // This is a placeholder, replace with your actual logic
    }
}