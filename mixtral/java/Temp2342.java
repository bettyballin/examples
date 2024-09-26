import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

@Component
public class Temp2342 implements AuthenticationSuccessHandler {

    private final UserDetailsService userDetailsService;

    @Autowired
    public Temp2342(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        // Use the injected UserDetailsService instance here
        response.getWriter().write("Authentication Successful");
    }

    public static void main(String[] args) {
        // Main method for test purposes
        System.out.println("Temp2342 class executed.");
    }
}