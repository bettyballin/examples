import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp1133 {
    @Autowired
    private AuthenticationManager authenticationManager;

    public static void main(String[] args) {
        Temp1133 temp = new Temp1133();
        temp.authenticateUser();
    }

    public void authenticateUser() {
        // Create a UsernamePasswordAuthenticationToken with dummy credentials
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken("username", "password");

        // Use the authentication manager to authenticate
        Authentication auth = this.authenticationManager.authenticate(authReq);

        // If successful set security context
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}