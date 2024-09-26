import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionEventPublisher implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Implementation code here
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Implementation code here
    }
}