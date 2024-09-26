import org.springframework.security.web.authentication.session.ConcurrentSessionControlStrategy;

public class Temp693 {
    public static void main(String[] args) {
        // Assuming you have set up the strategy with a SessionRegistry
        // Since this is a Spring Security component, you typically would use it within a Spring context
        // For demonstration purposes, this will just be a mock example
        
        // Create a mock SessionRegistry (in a real application, this would be configured in your Spring context)
        org.springframework.security.core.session.SessionRegistry sessionRegistry = new org.springframework.security.core.session.SessionRegistryImpl();
        
        // Create the ConcurrentSessionControlStrategy with the mock SessionRegistry
        ConcurrentSessionControlStrategy strategy = new ConcurrentSessionControlStrategy(sessionRegistry);
        
        // Set a maximum number of sessions for demonstration purposes
        strategy.setMaximumSessions(1);
        
        // Now you can call getMaximumSessionsForThisUser
        int maxSessions = strategy.getMaximumSessionsForThisUser();
        System.out.println("Maximum sessions for this user: " + maxSessions);
    }
}