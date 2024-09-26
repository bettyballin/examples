import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class Temp1038 implements AuthenticationSuccessHandler {

    public static void main(String[] args) {
        // This is just a main method for demonstration and won't be executed in a real scenario.
        // In a real Spring Boot application, the onAuthenticationSuccess method would be called by the framework.
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // Implement your logic here
        System.out.println("Authentication was successful!");
    }
}