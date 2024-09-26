import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;

import java.util.List;

public class CustomConcurrentSessionControlStrategy extends ConcurrentSessionControlAuthenticationStrategy {

    public CustomConcurrentSessionControlStrategy(SessionRegistry sessionRegistry) {
        super(sessionRegistry);
    }

    @Override
    protected void allowableSessionsExceeded(List<SessionInformation> sessions, int allowableSessions, SessionRegistry registry) throws SessionAuthenticationException {
        // Your custom message
        throw new SessionAuthenticationException("Your custom message here.");
    }
}