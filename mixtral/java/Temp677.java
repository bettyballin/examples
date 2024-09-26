import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;

public class Temp677 {
    public static void main(String[] args) {
        // Main method content
    }

    @PreAuthorize("hasRole('ADMIN')")
    public UserDetails getUserDetails(Long userId) {
        // Method implementation here
        return null;
    }
}