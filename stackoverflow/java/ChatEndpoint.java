import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;
import javax.websocket.OnOpen;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/chat")
public class ChatEndpoint {

    private static final Set<Session> sessions = 
            Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        String username = session.getUserPrincipal().getName();
        welcomeUser(session, username);
    }

    private void welcomeUser(Session session, String username) {
        // Implementation for welcoming user
    }

    // ... (other methods, if any)
}