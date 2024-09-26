import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;

public class CustomHttpSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        // Handle the creation of new sessions
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            String username = authentication.getName();
            System.out.println("New session created for user: " + username);
            // Store the authenticated user in your application's context
        } else {
            System.out.println("A new anonymous session was created.");
            // Handle anonymously logged-in users
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        // Handle session destruction
        System.out.println("Session destroyed: " + event.getSession().getId());
    }

    public static void main(String[] args) {
        // For testing purposes, create and destroy sessions manually
        CustomHttpSessionListener listener = new CustomHttpSessionListener();
        
        HttpSessionEvent createEvent = new HttpSessionEvent(new MockHttpSession());
        listener.sessionCreated(createEvent);
        
        HttpSessionEvent destroyEvent = new HttpSessionEvent(new MockHttpSession());
        listener.sessionDestroyed(destroyEvent);
    }
}

class MockHttpSession implements javax.servlet.http.HttpSession {
    // Implement the methods of HttpSession interface for testing
    private String id = "mock-session-id";

    @Override
    public long getCreationTime() { return 0; }

    @Override
    public String getId() { return id; }

    @Override
    public long getLastAccessedTime() { return 0; }

    @Override
    public javax.servlet.ServletContext getServletContext() { return null; }

    @Override
    public void setMaxInactiveInterval(int interval) {}

    @Override
    public int getMaxInactiveInterval() { return 0; }

    @Override
    public javax.servlet.http.HttpSessionContext getSessionContext() { return null; }

    @Override
    public Object getAttribute(String name) { return null; }

    @Override
    public Object getValue(String name) { return null; }

    @Override
    public Enumeration<String> getAttributeNames() { return null; }

    @Override
    public String[] getValueNames() { return new String[0]; }

    @Override
    public void setAttribute(String name, Object value) {}

    @Override
    public void putValue(String name, Object value) {}

    @Override
    public void removeAttribute(String name) {}

    @Override
    public void removeValue(String name) {}

    @Override
    public void invalidate() {}

    @Override
    public boolean isNew() { return false; }
}