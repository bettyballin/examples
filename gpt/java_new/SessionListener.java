import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Session is created.
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Session is about to be destroyed.
        Object attribute = se.getSession().getAttribute("yourAttributeName");
        // Do something with the attribute.
        storeAttribute(attribute);
    }

    private void storeAttribute(Object attribute) {
        // Implementation for storing the attribute.
    }
}