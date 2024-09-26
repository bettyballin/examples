import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class Temp1666 {

    public static void main(String[] args) {
        // Main method logic if needed
    }

    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) throws IOException {
        String attemptedUserName = ((UsernamePasswordAuthenticationToken) authenticationException.getAuthentication()).getName();

        // Now you can use the 'attemptedUserName' variable to store or display it as needed.
        System.out.println("Attempted Username: " + attemptedUserName);
    }
}