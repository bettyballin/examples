import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSession;

public class MySessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // No implementation needed for session creation
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        String attrName = "yourAttribute";

        HttpSession session = event.getSession();

        if (session != null) {
            Object attributeValue = session.getAttribute(attrName);

            // Store the value of your attribute here

            System.out.println("The value of '" + attrName
                    + "' before it was removed: "
                    + attributeValue
            );
        }
    }

    public static void main(String[] args) {
        // This main method is just to make this a standalone executable class
        // Normally, HttpSessionListener is used in a web application context
        // Here we simulate session creation and destruction for demonstration

        MySessionListener listener = new MySessionListener();
        HttpSessionEvent event = new HttpSessionEvent(new MockHttpSession());

        listener.sessionCreated(event);
        listener.sessionDestroyed(event);
    }

    // Mock HttpSession class for demonstration purposes
    static class MockHttpSession implements HttpSession {
        @Override
        public long getCreationTime() {
            return 0;
        }

        @Override
        public String getId() {
            return "mockSessionId";
        }

        @Override
        public long getLastAccessedTime() {
            return 0;
        }

        @Override
        public ServletContext getServletContext() {
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
        public HttpSessionContext getSessionContext() {
            return null;
        }

        @Override
        public Object getAttribute(String name) {
            if ("yourAttribute".equals(name)) {
                return "mockAttributeValue";
            }
            return null;
        }

        @Override
        public Object getValue(String name) {
            return getAttribute(name);
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
}