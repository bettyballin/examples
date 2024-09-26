import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.session.SessionRegistry;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SessionManagementService {

    private final Map<String, List<String>> userSessions = new ConcurrentHashMap<>();

    @Autowired
    private SessionRegistry sessionRegistry;

    public void registerSession(String username, String sessionId) {
        userSessions.computeIfAbsent(username, k -> new ArrayList<>()).add(sessionId);
    }

    // Call this method to log out the user
    public void logoutUser(String username) {
        List<String> sessions = userSessions.remove(username);
        if (sessions != null) {
            for (String sessionId : sessions) {
                sessionRegistry.removeSessionInformation(sessionId);
            }
        }
    }
}