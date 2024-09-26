import java.util.List;

public class Temp491 {
    public static void main(String[] args) {
        // Assuming sessionRegistry is defined and initialized elsewhere
        SessionRegistry sessionRegistry = new SessionRegistry();
        List<Object> userSessions = sessionRegistry.getAllPrincipals();
        
        // Print out the user sessions (or any other operation you need)
        for (Object session : userSessions) {
            System.out.println(session);
        }
    }
}

// Mock SessionRegistry class to make the code executable
class SessionRegistry {
    public List<Object> getAllPrincipals() {
        // Return a dummy list for demonstration purposes
        return List.of("User1", "User2", "User3");
    }
}