import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public class Temp52 {

    private static SessionRegistry sessionRegistry;

    public static void main(String[] args) {
        // Your code to initialize sessionRegistry here
    }

    public void logoutUserBySessionId(String sessionId) {
        List<Object> principals = sessionRegistry.getAllPrincipals();

        for (Object principal : principals) {
            if (principal instanceof UserDetails) {
                // Get the sessions associated with this user
                List<SessionInformation> sessionsInfoList =
                    sessionRegistry.getAllSessions(principal, false);

                for (SessionInformation si : sessionsInfoList) {
                    String currentSessionId = si.getSessionId();

                    if (currentSessionId != null &&
                        currentSessionId.equalsIgnoreCase(sessionId)) {

                        // Expire the session
                        si.expireNow();

                        break;
                    }
                }
            }
        }
    }
}