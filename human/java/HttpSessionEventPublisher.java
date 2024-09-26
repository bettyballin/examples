import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class HttpSessionEventPublisher implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session created: " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session destroyed: " + se.getSession().getId());
    }

    public static void main(String[] args) {
        // This code is typically executed in a servlet container, not as a standalone application.
        // However, to make it executable as a standalone application, we can create a dummy session event.
        HttpSessionEventPublisher publisher = new HttpSessionEventPublisher();
        HttpSessionEvent dummyEvent = new HttpSessionEvent(new DummyHttpSession("dummy-session-id"));
        publisher.sessionCreated(dummyEvent);
        publisher.sessionDestroyed(dummyEvent);
    }
}

class DummyHttpSession implements javax.servlet.http.HttpSession {
    private String id;

    public DummyHttpSession(String id) {
        this.id = id;
    }

    @Override
    public long getCreationTime() {
        return 0;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public long getLastAccessedTime() {
        return 0;
    }

    @Override
    public javax.servlet.ServletContext getServletContext() {
        return null;
    }

    @Override
    public void setMaxInactiveInterval(int interval) {
    }

    @Override
    public int getMaxInactiveInterval() {
        return 0;
    }

    @Override
    public javax.servlet.http.HttpSessionContext getSessionContext() {
        return null;
    }

    @Override
    public Object getAttribute(String name) {
        return null;
    }

    @Override
    public Object getValue(String name) {
        return null;
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return null;
    }

    @Override
    public String[] getValueNames() {
        return new String[0];
    }

    @Override
    public void setAttribute(String name, Object value) {
    }

    @Override
    public void putValue(String name, Object value) {
    }

    @Override
    public void removeAttribute(String name) {
    }

    @Override
    public void removeValue(String name) {
    }

    @Override
    public void invalidate() {
    }

    @Override
    public boolean isNew() {
        return false;
    }
}