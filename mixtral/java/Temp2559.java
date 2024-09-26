import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp2559 {

    private AuthenticationManager authenticationManager;

    public static void main(String[] args) {
        Temp2559 temp = new Temp2559();
        temp.runAuthentication("username", "enteredPassword", "hashedPassword");
    }

    public void runAuthentication(String username, String enteredPassword, String hashedPassword) {
        boolean isAuthenticated = new BCryptPasswordEncoder().matches(enteredPassword, hashedPassword);

        if (isAuthenticated) {
            Authentication authRequest = new UsernamePasswordAuthenticationToken(username, enteredPassword);

            try {
                Authentication authenticate = this.authenticationManager.authenticate(authRequest);
                System.out.println("User successfully authenticated");
                // Proceed if the user is successfully authenticated
            } catch (BadCredentialsException e) {
                System.out.println("Bad credentials");
            }
        } else {
            System.out.println("Password does not match");
        }
    }
}