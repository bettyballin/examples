import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;

import java.util.List;

public class YourClass2 {
    private final SessionRegistry sessionRegistry;

    public YourClass2(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    public void processUserSessions() {
        List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
        if (!allPrincipals.isEmpty()) {
            Object principal = allPrincipals.get(0);
            List<SessionInformation> principalSessions = sessionRegistry.getAllSessions(principal, false);
            // Process the sessions as needed
        }
    }
}