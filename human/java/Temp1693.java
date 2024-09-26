import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class Temp1693 {
    public static void main(String[] args) {
        // Simulate a user being authenticated
        SecurityContextHolder.getContext().setAuthentication(
            new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                new User("username", "password", new ArrayList<>()), null)
        );

        // Retrieve the authenticated user
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // Print the username to verify
        System.out.println("Authenticated user: " + principal.getUsername());
    }
}