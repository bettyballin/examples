import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompFrameHandler;

// ... other imports

public class MyStompClient {

    private StompSession stompSession;
    private String myCustomIdentifier;

    public MyStompClient(StompSession stompSession, String myCustomIdentifier) {
        this.stompSession = stompSession;
        this.myCustomIdentifier = myCustomIdentifier;
    }

    public void subscribeToChats(StompFrameHandler onMessage) {
        stompSession.subscribe("/queue/chats" + "-" + myCustomIdentifier, onMessage);
    }

    // ... other methods
}