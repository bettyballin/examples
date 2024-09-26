import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Temp2401 {
    private Authentication authentication;

    @Autowired
    public Temp2401(Authentication authentication) {
        this.authentication = authentication;
    }

    public static void main(String[] args) {
        // Obtain the authentication from the security context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Then you can get the username like this
        String currentUser = (authentication != null) ? authentication.getName() : null;

        if (currentUser != null) {
            // Display the username
            System.out.println("Current user: " + currentUser);
        } else {
            // No user is logged in
            System.out.println("No user is logged in");
        }
    }
}