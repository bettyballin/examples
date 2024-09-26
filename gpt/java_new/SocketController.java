import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import java.security.Principal;

public class SocketController {

    @MessageMapping("/user/sockettest")
    @SendTo("/topic/sockettestresult")
    public String sockAdd(Principal principal, String[] listIds) {
        // Here, you can access the username from the principal object
        String username = principal.getName();

        // Your logic
        String stringRet = ""; // Assuming you will populate this with the result of your logic

        return stringRet;
    }
}