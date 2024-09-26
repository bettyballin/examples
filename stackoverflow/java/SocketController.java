import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import java.security.Principal;

public class SocketController {

    @MessageMapping("/user/sockettest")
    @SendTo("/topic/sockettestresult")
    public String sockAdd(ListId[] listIds, Principal principal) {
        //do whatever you want
        String stringRet = "result";
        return stringRet;
    }
    
    // Assuming ListId is a class you have in your project
    public static class ListId {
        // Your ListId class implementation here
    }
}