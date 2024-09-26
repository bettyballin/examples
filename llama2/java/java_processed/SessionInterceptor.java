import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SessionInterceptor implements HttpSessionListener {
    private static final Logger LOGGER = Logger.getLogger(SessionInterceptor.class.getName());

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Retrieve the session attribute you want to keep
        Object attrValueObj = se.getSession().getAttribute("myAttr");
        if (attrValueObj != null) {
            String attrValue = attrValueObj.toString();
            // Store the attribute value somewhere (e.g a database)
            // ...
            LOGGER.log(Level.INFO, "Session attribute 'myAttr' value: {0}", attrValue);
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // No-op
    }
}