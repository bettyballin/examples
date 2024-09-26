import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener1;

public class SessionListener1 implements HttpSessionListener1 {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Session is created
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Session is destroyed
        // Cannot set attribute on a session that is being destroyed
    }
}