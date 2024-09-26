import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class CustomWebsocketHandshakeInterceptor implements HandshakeInterceptor {

    private static final String USER_SESSION = "USER_SESSION";

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        HttpSession session = ((ServletWebRequest) request).getNativeRequest(HttpSession.class);

        if (session != null && !attributes.containsKey(USER_SESSION)) {
            attributes.put(USER_SESSION, new CustomPrincipal(session));
        }

        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
                               WebSocketHandler wsHandler, Exception exception) {
        // No implementation needed for this example
    }

    private static class CustomPrincipal {
        private HttpSession session;

        public CustomPrincipal(HttpSession session) {
            this.session = session;
        }

        // Add your methods here
    }
}