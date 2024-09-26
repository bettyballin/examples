import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.security.Principal;

@Component
public class MyWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        Principal principal = session.getPrincipal();
        if (principal != null) {
            String sessionId = principal.getName();
            // Use sessionId to send messages
            session.sendMessage(new TextMessage("Received message: " + message.getPayload() + " from session: " + sessionId));
        }
    }

    public static void main(String[] args) {}
}