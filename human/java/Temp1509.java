import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;

public class Temp1509 {
    public static void main(String[] args) {
        // Test call to onAuthenticationFailure method
        Temp1509 temp = new Temp1509();
        temp.onAuthenticationFailure(null, null, new AuthenticationException("Test Exception") {});
    }

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
        // Handle authentication failure
        System.out.println("Authentication failed: " + exception.getMessage());
    }
}