import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;

public class SessionManager {
    private final SessionRegistry sessionRegistry;

    public SessionManager(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    public List<Object> getUserSessions() {
        return sessionRegistry.getAllPrincipals();
    }
}