import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;

public class WebSocketMessageHandler extends TextWebSocketHandler {

    public static final Map<String, Long> SESSION_USERID = new ConcurrentHashMap<>();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        // Dummy message type and userId for compilation
        final int AUTH = 1;
        final int CHAT = 2;
        final long userId = 123L;

        // Assuming message has a method getType that returns an int
        if (getType(message) == AUTH) {
            // do auth
            // if auth succeed, cache the user
            SESSION_USERID.put(session.getId(), userId);
        } else if (getType(message) == CHAT) {
            Long sessionUserId = SESSION_USERID.get(session.getId());
            if (sessionUserId == null) {
                // Send error or close session
            } else {
                // Send messages to other people
            }
        }
    }

    private int getType(TextMessage message) {
        // Dummy implementation
        return 0;
    }
}