import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SessionListener2 implements HttpSessionListener2 {

    private static final Log log = LogFactory.getLog(SessionListener2.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("Session Created with session id: " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("Session Destroyed, Session id: " + se.getSession().getId());
    }
}