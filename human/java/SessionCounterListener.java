import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebListener
public class SessionCounterListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        session.setMaxInactiveInterval(60 * 15);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
        ContractorService contractorService = (ContractorService) ctx.getBean("contractorService");

        // Assuming you have a way to get security contexts from the session
        // Replace with actual implementation
        for (SecurityContext securityContext : getSecurityContextsFromSession(session)) {
            Authentication authentication = securityContext.getAuthentication();
            CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
            // Perform your logic here
        }
    }

    // Mock method to illustrate obtaining security contexts from session
    // Replace with your actual method of retrieving security contexts
    private Iterable<SecurityContext> getSecurityContextsFromSession(HttpSession session) {
        // Implementation to retrieve security contexts
        return new ArrayList<>();
    }
}