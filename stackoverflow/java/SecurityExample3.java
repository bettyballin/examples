import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityExample3 {
    public static void main(String[] args) {
        UserDetails userDetails = new UserDetailsImpl(user); // Assuming UserDetailsImpl is already defined elsewhere

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}

// Assuming a custom UserDetails implementation
class UserDetailsImpl implements UserDetails {
    // Constructor and method implementations for UserDetails interface
    public UserDetailsImpl(User user) {
        // Initialize with user object
    }
    // Implement all required methods from UserDetails here
}