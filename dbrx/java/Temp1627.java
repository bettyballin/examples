import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp1627 {
    @Autowired
    private AuthenticationManager authenticationManager;

    public static void main(String[] args) {
        Temp1627 temp = new Temp1627();
        temp.authenticate("username", "password");
    }

    public void authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(username, password);
        try {
            Authentication authResult = this.authenticationManager.authenticate(authReq);
            SecurityContextHolder.getContext().setAuthentication(authResult);
        } catch (BadCredentialsException e) {
            // Handle exception
        }
    }
}