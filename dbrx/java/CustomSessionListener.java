import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class CustomSessionListener implements HttpSessionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomSessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Not needed in this case but you can add logging here if desired.
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        String sessionId = session.getId();

        LOGGER.info("Session invalidated: {}", sessionId);
    }
}