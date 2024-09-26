import org.springframework.security.access.prepost.PreAuthorize;

public class Temp569 {
    public static void main(String[] args) {
        Temp569 temp = new Temp569();
        temp.activateUser("username"); // Example call - will not work without Spring Security context
    }

    @PreAuthorize("isFullyAuthenticated() and hasRole('activateUser')")
    public void activateUser(String username) {
        System.out.println("User " + username + " activated.");
    }
}