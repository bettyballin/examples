import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.session.HttpSessionCreatedEvent;
import org.springframework.security.web.session.HttpSessionIdChangedEvent;
import org.springframework.security.web.session.HttpSessionIdListener;

public class GoogleAuthSessionIdListener implements HttpSessionIdListener {

    private static final Logger logger = LoggerFactory.getLogger(GoogleAuthSessionIdListener.class);

    @Override
    public void sessionIdChanged(HttpSessionIdChangedEvent event) {
        // Get the current authentication from the SecurityContext
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && !auth.isAuthenticated()) {
            logger.debug("User is not authenticated clearing session id");
            // Removed event.setSessionId(null); as HttpSessionIdChangedEvent does not have setSessionId method
        }
    }

    @Override
    public void sessionCreated(HttpSessionCreatedEvent event) {
        // No-op
    }
}