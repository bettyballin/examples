import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {
    private int userID;

    // Assuming there's an existing constructor for CustomUser
    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities, int userID) {
        super(username, password, authorities);
        this.userID = userID;
    }

    public int getUserID() {
        return this.userID;
    }

    // Rest of your CustomUser class
}

// Somewhere in your application code
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
Object principal = authentication.getPrincipal();

if (principal instanceof CustomUser) {
    CustomUser customUser = (CustomUser) principal;
    int userID = customUser.getUserID();
    // Use userID as needed
} else {
    // Handle the case where the principal is not an instance of CustomUser
}