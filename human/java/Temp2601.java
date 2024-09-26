import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;

public class Temp2601 {
    public static void main(String[] args) {
        // Mock objects for demonstration purposes
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        Authentication authentication = null;

        onLogoutSuccess(request, response, authentication);
    }

    public static void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // Your logic here
        System.out.println("Logout successful");
    }
}