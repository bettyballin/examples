import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionListener1 implements HttpSessionListener1 {

    private static final Logger logger = LoggerFactory.getLogger(SessionListener1.class);

    @Autowired
    private IWebsocketService websocketService; // Assume IWebsocketService is a valid interface

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.debug("sessionCreated: {}", se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        String sessionId = se.getSession().getId();
        logger.debug("sessionDestroyed: {}", sessionId);
        websocketService.sendLoginStatus(sessionId, false);
    }
}