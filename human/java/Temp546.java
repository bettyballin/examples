import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Temp546 {
    public static void main(String[] args) {
        // Mock request object for demonstration, in real scenario this is provided by the servlet container
        HttpServletRequest request = new MockHttpServletRequest();
        HttpSession session = request.getSession();
        session.setAttribute("activation-time", System.currentTimeMillis());
    }
}

// Mock classes to simulate HttpServletRequest and HttpSession
class MockHttpServletRequest implements HttpServletRequest {
    private HttpSession session = new MockHttpSession();

    @Override
    public HttpSession getSession() {
        return session;
    }

    // Implement other methods from HttpServletRequest as needed
    // For simplicity, these methods can return default values or throw UnsupportedOperationException
    // ...
}

class MockHttpSession implements HttpSession {
    // Implement methods from HttpSession as needed
    // For simplicity, these methods can store attributes in a map
    private java.util.Map<String, Object> attributes = new java.util.HashMap<>();

    @Override
    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    @Override
    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    // Implement other methods from HttpSession as needed
    // For simplicity, these methods can return default values or throw UnsupportedOperationException
    // ...
}