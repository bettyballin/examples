import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MyController3 {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public MyController3(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/chats")
    public void handleChat(@Payload ChatMessage message) {
        this.simpMessagingTemplate.convertAndSend("/queue/chats-" + "mycustomidentifier", "[" + getTimestamp() + "]:" + message.getMessage());
    }

    private String getTimestamp() {
        // method implementation goes here
        return ""; // placeholder return value
    }

    // Assuming ChatMessage is a valid class elsewhere in the codebase
    public static class ChatMessage {
        private String message;

        public String getMessage() {
            return message;
        }

        // other fields and methods
    }
}