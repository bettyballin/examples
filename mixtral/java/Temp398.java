import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

public class Temp398 {
    public static void main(String[] args) {
        // Dummy objects to simulate the environment
        CustomUserDetails customUserDetails = new CustomUserDetails("username", "password");
        HttpSession session = new DummyHttpSession();
        ServletContext sc = new DummyServletContext();

        // Store in the session
        session.setAttribute("user", customUserDetails);

        // Or store in the servlet context
        sc.setAttribute("user", customUserDetails);

        // Output to verify
        System.out.println("User stored in session: " + session.getAttribute("user"));
        System.out.println("User stored in servlet context: " + sc.getAttribute("user"));
    }
}

// Dummy implementation of CustomUserDetails
class CustomUserDetails {
    private String username;
    private String password;

    public CustomUserDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "CustomUserDetails{username='" + username + "', password='" + password + "'}";
    }
}

// Dummy implementation of HttpSession
class DummyHttpSession implements HttpSession {
    private java.util.Map<String, Object> attributes = new java.util.HashMap<>();

    @Override
    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    @Override
    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    // Implement other methods as no-ops or return default values
    @Override
    public long getCreationTime() { return 0; }

    @Override
    public String getId() { return null; }

    @Override
    public long getLastAccessedTime() { return 0; }

    @Override
    public ServletContext getServletContext() { return null; }

    @Override
    public void setMaxInactiveInterval(int interval) { }

    @Override
    public int getMaxInactiveInterval() { return 0; }

    @Override
    public javax.servlet.http.HttpSessionContext getSessionContext() { return null; }

    @Override
    public Object getValue(String name) { return null; }

    @Override
    public Enumeration<String> getAttributeNames() { return null; }

    @Override
    public String[] getValueNames() { return new String[0]; }

    @Override
    public void putValue(String name, Object value) { }

    @Override
    public void removeAttribute(String name) { attributes.remove(name); }

    @Override
    public void removeValue(String name) { }

    @Override
    public void invalidate() { }

    @Override
    public boolean isNew() { return false; }
}

// Dummy implementation of ServletContext
class DummyServletContext implements ServletContext {
    private java.util.Map<String, Object> attributes = new java.util.HashMap<>();

    @Override
    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    @Override
    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    // Implement other methods as no-ops or return default values
    @Override
    public String getContextPath() { return null; }

    @Override
    public ServletContext getContext(String uripath) { return null; }

    @Override
    public int getMajorVersion() { return 0; }

    @Override
    public int getMinorVersion() { return 0; }

    @Override
    public int getEffectiveMajorVersion() { return 0; }

    @Override
    public int getEffectiveMinorVersion() { return 0; }

    @Override
    public String getMimeType(String file) { return null; }

    @Override
    public Set<String> getResourcePaths(String path) { return null; }

    @Override
    public URL getResource(String path) { return null; }

    @Override
    public InputStream getResourceAsStream(String path) { return null; }

    @Override
    public RequestDispatcher getRequestDispatcher(String path) { return null; }

    @Override
    public RequestDispatcher getNamedDispatcher(String name) { return null; }

    @Override
    public Servlet getServlet(String name) { return null; }

    @Override
    public Enumeration<Servlet> getServlets() { return null; }

    @Override
    public Enumeration<String> getServletNames() { return null; }

    @Override
    public void log(String msg) { }

    @Override
    public void log(Exception exception, String msg) { }

    @Override
    public void log(String message, Throwable throwable) { }

    @