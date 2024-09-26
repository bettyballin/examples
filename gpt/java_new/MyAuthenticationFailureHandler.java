import org.springframework.stereotype.Component;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.springframework.security.core.AuthenticationException;

@Component
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String errorMessage = "Your login attempt was not successful, try again.";
        
        errorMessage = URLEncoder.encode(errorMessage, StandardCharsets.UTF_8.toString());
        
        getRedirectStrategy().sendRedirect(request, response, "/guest/login?error=" + errorMessage);
    }
}