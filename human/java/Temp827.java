import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

public class Temp827 {
    public static void main(String[] args) {
        // Dummy objects for demonstration purposes
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        Authentication authentication = null;

        logout(request, response, authentication);
    }

    public static void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (authentication != null){
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
    }
}