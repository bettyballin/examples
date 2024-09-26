import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;

public class Temp2574 {
    public static void main(String[] args) {
        // Dummy objects for demonstration purposes
        Authentication authentication = null;
        HttpServletRequest request = null;
        HttpServletResponse response = null;

        onAuthentication(authentication, request, response);
    }

    public static void onAuthentication(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        // Implementation of the method
        System.out.println("Authentication successful!");
    }
}