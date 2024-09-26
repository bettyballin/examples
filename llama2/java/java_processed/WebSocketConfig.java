import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry
            .addHandler(new MyWebSocketHandler(), "/websocket")
            .setAllowedOrigins("*")
            .setHandshakeHandler(new DefaultHandshakeHandler() {
                @Override
                protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
                    String sessionId = request.getHeaders().getFirst("SPRING_SESSION_ID");
                    return new SessionPrincipal(sessionId);
                }
            });
    }

    private class MyWebSocketHandler implements WebSocketHandler {
        @Override
        public void afterConnectionEstablished(WebSocketSession session) throws Exception {
            // Implement after connection established logic here
        }

        @Override
        public void handleMessage(WebSocketSession session, Object message) throws Exception {
            // Implement handle message logic here
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                session.sendMessage(new TextMessage("Received message: " + textMessage.getText()));
            }
        }

        @Override
        public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
            // Implement handle transport error logic here
        }

        @Override
        public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
            // Implement after connection closed logic here
        }

        @Override
        public boolean supportsPartialMessages() {
            return false;
        }
    }

    private class SessionPrincipal implements Principal {
        private String sessionId;

        public SessionPrincipal(String sessionId) {
            this.sessionId = sessionId;
        }

        @Override
        public String getName() {
            return sessionId;
        }
    }
}