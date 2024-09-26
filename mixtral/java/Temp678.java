import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PostFilter;

public class Temp678 {

    public static void main(String[] args) {
        // Main method implementation
    }

    @PreAuthorize("hasRole('USER')")
    public List<UserDetails> getAllUsers() {
        // Method implementation
        return null;
    }

    // Filter out users that are not owned by current principal
    @PostFilter("filterObject.owner == authentication.principal or hasRole('ADMIN')")
    public List<UserDetails> filterOwnedUsers(List<UserDetails> userDetails) {
        return userDetails;
    }
}

// Dummy UserDetails class for demonstration purposes
class UserDetails {
    String owner;

    // Constructor, getters, and setters
    public UserDetails(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}