import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import javax.servlet.http.HttpSession;

public class CustomSessionListener implements HttpSessionListener {

    private final SessionRegistry sessionRegistry;

    @Autowired
    public CustomSessionListener(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        // Add logic to add the session back to the SessionRegistry
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        // Optionally, remove the session from the SessionRegistry
    }
}