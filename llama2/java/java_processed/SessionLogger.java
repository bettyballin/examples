import javax.servlet.http.*;
import javax.servlet.annotation.WebListener;
import java.util.logging.Logger;

@WebListener
public class SessionLogger implements HttpSessionListener {
    private static final Logger logger = Logger.getLogger(SessionLogger.class.getName());

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        // You can also log new sessions here
        String sessionId = event.getSession().getId();
        long timestamp = System.currentTimeMillis();
        logger.info(String.format("Session '%s' created at %d", sessionId, timestamp));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        // Log the session ID and timestamp
        String sessionId = event.getSession().getId();
        long timestamp = System.currentTimeMillis();
        logger.info(String.format("Session '%s' destroyed at %d", sessionId, timestamp));
    }
}