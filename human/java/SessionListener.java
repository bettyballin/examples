import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Component
public class SessionListener implements HttpSessionListener {

    private static final Logger logger = LoggerFactory.getLogger(SessionListener.class);

    @Autowired
    private IWebsocketService websocketService; // your own service here

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

interface IWebsocketService {
    void sendLoginStatus(String sessionId, boolean status);
}