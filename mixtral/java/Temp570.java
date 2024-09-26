import org.springframework.security.access.prepost.PreAuthorize;

public class Temp570 {
    public static void main(String[] args) {
        Temp570 temp = new Temp570();
        temp.activateUser("exampleUser");
    }

    @PreAuthorize("hasRole('activateUser')")
    public void activateUser(String username) {
        // Implementation of user activation
        System.out.println("User " + username + " activated.");
    }
}


Note: Ensure you have the necessary Spring Security configurations and dependencies in your project to make the `@PreAuthorize` annotation work correctly.