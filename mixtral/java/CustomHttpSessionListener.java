import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class CustomHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {}

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Invalidate Shiro's Session
        Subject currentUser = SecurityUtils.getSubject();

        if (currentUser != null && !currentUser.isRemembered()) {
            currentUser.logout();
        }
    }

    // Main method for testing purposes
    public static void main(String[] args) {
        // Here you can test the CustomHttpSessionListener class
        // Example: Simulating session destroyed event
        CustomHttpSessionListener listener = new CustomHttpSessionListener();
        HttpSessionEvent event = new HttpSessionEvent(null); // Passing null for simplicity
        listener.sessionDestroyed(event);
    }
}