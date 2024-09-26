import java.util.concurrent.ConcurrentHashMap;

public class SessionRegistry {
    private final ConcurrentHashMap<String, Object> sessions = new ConcurrentHashMap<>();

    public void registerNewSession(String sessionId, Object principal) {
        sessions.put(sessionId, principal);
    }
    
    // Additional methods such as unregisterSession, getSession, etc. can be implemented here
}