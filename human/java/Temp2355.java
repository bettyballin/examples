import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Temp2355 {
    public static void main(String[] args) {
        // Simulated authenticated user details
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        String authorities = userDetails.getAuthorities().toString();

        // Replace with actual user email and role check logic
        String userEmail = "user@example.com"; // Example user email
        boolean isAdmin = authorities.contains("ROLE_ADMIN");

        if (username.equals(userEmail) || isAdmin) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}