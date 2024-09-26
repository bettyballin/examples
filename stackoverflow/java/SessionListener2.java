import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

public class SessionListener2 implements HttpSessionListener2 {

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        SecurityContext context = (SecurityContext) session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
        if(context != null) {
            Authentication authentication = context.getAuthentication();
            if (authentication != null) {
                // Perform operations with authentication object
                String username = authentication.getName();
                // Do something with the username
            }
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Handle session creation if necessary
    }
}