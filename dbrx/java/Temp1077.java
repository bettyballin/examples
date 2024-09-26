import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.mock.web.MockHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

public class Temp1077 {

    public static void main(String[] args) {
        // Example usage
        HttpServletRequest request = new MockHttpServletRequest(); // This should be an actual HttpServletRequest object
        String username = "user";
        String password = "password";

        authenticateUser(username, password, request);
    }

    public static void authenticateUser(String username, String password, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, password);
        auth.setDetails(new WebAuthenticationDetails(request));
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}