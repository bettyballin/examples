import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.web.context.support.WebApplicationContextUtils;
import org.springframework.stereotype.Component;

@WebListener
public class SessionCounterListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        session.setMaxInactiveInterval(60 * 15);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        // Implementation here depends on the actual use case and the ContractorService
        // As the snippet provided does not actually use contractorService, we cannot provide a meaningful implementation
    }

}