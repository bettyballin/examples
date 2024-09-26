import java.security.Principal;

public class CustomPrincipal implements Principal {
    private final String sessionId;

    public CustomPrincipal(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String getName() {
        return sessionId;
    }

    public static void main(String[] args) {
        CustomPrincipal principal = new CustomPrincipal("session123");
        System.out.println("Principal Name: " + principal.getName());
    }
}