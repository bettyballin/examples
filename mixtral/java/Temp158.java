import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.core.Authentication;

public class Temp158 {
    public static void main(String[] args) {
        // Main method implementation if needed
    }

    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // Retrieve the attribute from the same request
        String ticket = (String) request.getAttribute("TICKET");
    }
}