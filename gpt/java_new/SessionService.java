import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SessionService {

    private final SessionRegistry sessionRegistry;

    @Autowired
    public SessionService(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    public List<SessionInformation> getAllSessionsForUser(String username) {
        List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
        List<SessionInformation> userSessions = new ArrayList<>();
        for (Object principal : allPrincipals) {
            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                if (userDetails.getUsername().equals(username)) {
                    userSessions.addAll(sessionRegistry.getAllSessions(principal, false));
                }
            }
        }
        return userSessions;
    }
}