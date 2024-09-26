import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import java.util.Arrays;
import java.util.List;

public class Temp589 {

    public static void main(String[] args) {
        List<Transport> transports = Arrays.asList(new WebSocketTransport(new StandardWebSocketClient()));
        WebSocketClient stompClient = new SockJsClient(transports);

        stompClient.doHandshake(new StompSessionHandlerAdapter() {
        }, "ws://your_websocket_endpoint") {
            @Override
            public void beforeSend(WebSocketSession session, WebSocketMessage<?> message) {
                session.getHandshakeHeaders().add("X-Auth-Token", "yourSessionId");
            }
        };
    }
}