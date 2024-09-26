import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

public class Temp2836 implements HttpSessionListener {
    public static void main(String[] args) {
        // This part of the code is not necessary for the HttpSessionListener to work
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        SecurityContext context = (SecurityContext) session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
        if (context != null) {
            Authentication authentication = context.getAuthentication();
            if (authentication != null) {
                System.out.println("User: " + authentication.getName());
            } else {
                System.out.println("No authentication found in session.");
            }
        } else {
            System.out.println("No SecurityContext found in session.");
        }
    }
}