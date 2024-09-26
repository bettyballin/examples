import javax.servlet.http.HttpSession;

public class Temp976 {
    public static void main(String[] args) {
        // Simulating a session attribute retrieval
        HttpSession session = new MockHttpSession();
        session.setAttribute("attr_name", "Sample Attribute Value");

        Object attr = session.getAttribute("attr_name");
        System.out.println(attr);
    }
}

// MockHttpSession class to simulate HttpSession for demonstration purposes
class MockHttpSession implements HttpSession {
    private java.util.Map<String, Object> attributes = new java.util.HashMap<>();

    @Override
    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    @Override
    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    // Implementing only the required methods for the demonstration
    @Override
    public Object getValue(String name) { return null; }
    @Override
    public java.util.Enumeration<String> getAttributeNames() { return null; }
    @Override
    public long getCreationTime() { return 0; }
    @Override
    public String getId() { return null; }
    @Override
    public long getLastAccessedTime() { return 0; }
    @Override
    public int getMaxInactiveInterval() { return 0; }
    @Override
    public javax.servlet.ServletContext getServletContext() { return null; }
    @Override
    public javax.servlet.http.HttpSessionContext getSessionContext() { return null; }
    @Override
    public Object getValueNames() { return null; }
    @Override
    public void invalidate() {}
    @Override
    public boolean isNew() { return false; }
    @Override
    public void putValue(String name, Object value) {}
    @Override
    public void removeAttribute(String name) {}
    @Override
    public void removeValue(String name) {}
    @Override
    public void setMaxInactiveInterval(int interval) {}
}