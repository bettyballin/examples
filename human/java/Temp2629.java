import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class Temp2629 {
    public static void main(String[] args) {
        // Assume message and UserPrincipal are provided for this example
        Message message = new Message(); // This should be replaced with the actual message object
        UserPrincipal userPrincipal = new UserPrincipal("username"); // This should be replaced with the actual user principal

        // Set the user principal in the context
        message.getBayeuxContext().setUserPrincipal(userPrincipal);

        SecurityContextHolder.getContext().setAuthentication(
            new UsernamePasswordAuthenticationToken(
                message.getBayeuxContext().getUserPrincipal(), null, null
            )
        );
    }
}

// Mock classes for demonstration purposes
class Message {
    private BayeuxContext context = new BayeuxContext();

    public BayeuxContext getBayeuxContext() {
        return context;
    }
}

class BayeuxContext {
    private UserPrincipal userPrincipal;

    public UserPrincipal getUserPrincipal() {
        return userPrincipal;
    }

    public void setUserPrincipal(UserPrincipal userPrincipal) {
        this.userPrincipal = userPrincipal;
    }
}

class UserPrincipal {
    private String name;

    public UserPrincipal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}