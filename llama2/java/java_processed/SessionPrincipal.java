import java.security.Principal;

public class SessionPrincipal implements Principal {
    private String sessionId;

    public SessionPrincipal(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String getName() {
        return sessionId;
    }

    public static void main(String[] args) {
        SessionPrincipal sp = new SessionPrincipal("12345");
        System.out.println("Session ID: " + sp.getName());
    }
}