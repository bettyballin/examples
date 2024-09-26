import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import java.io.IOException;
import org.springframework.security.core.Authentication;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // Your custom code here to put a message on Kafka stream.
        
        // Redirecting to the default success URL
        getRedirectStrategy().sendRedirect(request, response, "/defaultSuccessUrl");
    }

    private org.springframework.security.web.RedirectStrategy getRedirectStrategy() {
        return new org.springframework.security.web.DefaultRedirectStrategy();
    }
}