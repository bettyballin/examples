import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;

public class Temp2339 {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public static void main(String[] args) {
        // This main method is just a placeholder.
        // To run this code, you need a Spring Security context.
    }

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        DefaultSavedRequest defaultSavedRequest = (DefaultSavedRequest) request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");
        if (defaultSavedRequest != null) {
            String targetURL = defaultSavedRequest.getRedirectUrl();
            redirectStrategy.sendRedirect(request, response, targetURL);
        }
    }
}