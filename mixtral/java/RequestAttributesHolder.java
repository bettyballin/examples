import javax.servlet.http.HttpServletRequest;

public final class RequestAttributesHolder {

    private static ThreadLocal<String> currentUri = new InheritableThreadLocal<>();

    public static void setCurrentUriAndMethod(HttpServletRequest request) {
        // Store the requested URI and method
        String uri = request.getServletPath();
        if (request.getAttribute("javax.servlet.forward.path_info") != null) {
            uri += "/" + request.getAttribute("javax.servlet.forward.path_info");
        }
        currentUri.set(uri);
    }

    public static String getCurrentUri() {
        return currentUri.get();
    }

    // Clear the stored values
    private RequestAttributesHolder() {
        throw new AssertionError("No instances for you!");
    }

    public static void clear() {
        currentUri.remove();
    }

    public static void main(String[] args) {
        // Test the RequestAttributesHolder class (Note: This is just a simulation)
        HttpServletRequest request = new MockHttpServletRequest("GET", "/example/path");
        request.setAttribute("javax.servlet.forward.path_info", "info");
        
        setCurrentUriAndMethod(request);
        System.out.println("Current URI: " + getCurrentUri());
        
        clear();
        System.out.println("Current URI after clear: " + getCurrentUri());
    }
}

// Mock implementation of HttpServletRequest for testing purposes
class MockHttpServletRequest implements HttpServletRequest {
    private String method;
    private String servletPath;
    private Map<String, Object> attributes = new HashMap<>();

    public MockHttpServletRequest(String method, String servletPath) {
        this.method = method;
        this.servletPath = servletPath;
    }

    @Override
    public String getServletPath() {
        return servletPath;
    }

    @Override
    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    @Override
    public void setAttribute(String name, Object o) {
        attributes.put(name, o);
    }

    // Other unimplemented methods from HttpServletRequest interface
    // Implement these methods as needed for your tests
    // ...
}