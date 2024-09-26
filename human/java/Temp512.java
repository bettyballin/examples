public class Temp512 {
    public static void main(String[] args) {
        Object principal = new Object(); // Example principal object
        boolean includeExpiredSessions = true; // Example flag
        
        getAllSessions(principal, includeExpiredSessions);
    }
    
    public static void getAllSessions(Object principal, boolean includeExpiredSessions) {
        // Your implementation here
        System.out.println("Principal: " + principal);
        System.out.println("Include Expired Sessions: " + includeExpiredSessions);
    }
}