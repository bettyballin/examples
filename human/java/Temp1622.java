import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import java.security.Principal;

public class Temp1622 {
    public static void main(String[] args) {
        // This is just a placeholder to make the class executable
        System.out.println("Server running...");
    }

    @MessageMapping("/user/sockettest")
    @SendTo("/topic/sockettestresult")
    public String sockAdd(ListId[] listIds, Principal principal) {
        // do whatever you want
        String stringRet = "Sample Response";
        return stringRet;
    }
}

class ListId {
    // Define the ListId class properties and methods here
}