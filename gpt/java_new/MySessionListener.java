import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionEvent;

public class MySessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Handle session creation if necessary
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Assuming 'userId' is the attribute name where the user ID is stored
        Object userIdObj = se.getSession().getAttribute("userId");
        if (userIdObj instanceof String) {
            deleteUserFiles((String) userIdObj);
        }
    }

    private void deleteUserFiles(String userId) {
        // Implement file deletion logic here
    }
}