import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Temp1127 {
    public static void main(String[] args) {
        // This is a placeholder for actual security context setup
        // Setup security context and authentication details as per your application's requirements
        // Here, we are just simulating the process
        
        // Assuming the SecurityContextHolder is correctly set up with authentication details
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("User Details: " + userDetails);
    }
}