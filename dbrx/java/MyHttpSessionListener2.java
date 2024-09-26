import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Do nothing
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        Object principalObject = session.getAttribute("SPRING_SECURITY_CONTEXT");
        if (principalObject != null && principalObject instanceof SecurityContextImpl) {
            Authentication authentication = ((SecurityContextImpl) principalObject).getAuthentication();
            if (authentication != null && authentication.getPrincipal() != null) {
                Object principal = authentication.getPrincipal();
                if (principal instanceof UserDetails) {
                    UserDetails userDetails = (UserDetails) principal;
                    String userId = userDetails.getUsername(); // or any other user id
                    deleteFilesByUserId(userId);
                }
            }
        }
    }

    private void deleteFilesByUserId(String userId) {
        // code to delete files by user ID goes here
    }
}