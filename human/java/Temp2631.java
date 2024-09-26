import java.security.Principal;

public class Temp2631 {
    public static void main(String[] args) {
        // Simulated message object and context for demonstration purposes
        Message message = new Message();
        BayeuxContext context = message.getBayeuxContext();
        Principal userPrincipal = context.getUserPrincipal();
        
        if (userPrincipal instanceof Principal) {
            System.out.println("The userPrincipal is an instance of java.security.Principal");
        } else {
            System.out.println("The userPrincipal is not an instance of java.security.Principal");
        }
    }
}

// Simulated classes to make the code executable
class Message {
    public BayeuxContext getBayeuxContext() {
        return new BayeuxContext();
    }
}

class BayeuxContext {
    public Principal getUserPrincipal() {
        return new Principal() {
            @Override
            public String getName() {
                return "userPrincipal";
            }
        };
    }
}