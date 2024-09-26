import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSession;

public class MyHttpSessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se) {}

    public void sessionDestroyed(HttpSessionEvent se) {        
        HttpSession session = se.getSession();
        Object myAttribute = session.getAttribute("myAttributeName");
        // Store your attribute here.
    }
}