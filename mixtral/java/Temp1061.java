import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.AuthenticationManager;

public class Temp1061 {
    private AuthenticationManager authManager;

    public Temp1061(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    public static void main(String[] args) {
        // Example usage
        AuthenticationManager authManager = // Initialize your AuthenticationManager here
        Temp1061 temp1061 = new Temp1061(authManager);
        temp1061.authenticateUser("username", "password");
    }

    public void authenticateUser(String username, String password) {
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(username, password);
        Authentication auth = this.authManager.authenticate(authReq);
        SecurityContextHolder.getContext().setAuthentication(auth);

        // Now you can access the authenticated principal
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userDetails);
    }
}