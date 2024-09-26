import javax.servlet.http.HttpServletRequest;

public class MethodRequestMatcher implements RequestMatcher {
    private RequestMethod method;

    public MethodRequestMatcher(RequestMethod method) {
        this.method = method;
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        if (method == null) {
            return false;
        }
        return request.getMethod().equals(method.name());
    }

    public static void main(String[] args) {
        // Example usage
        HttpServletRequest request = new MockHttpServletRequest("GET", "/example");
        MethodRequestMatcher matcher = new MethodRequestMatcher(RequestMethod.GET);
        System.out.println(matcher.matches(request)); // Should print true or false
    }
}

interface RequestMatcher {
    boolean matches(HttpServletRequest request);
}

enum RequestMethod {
    GET, POST, PUT, DELETE, PATCH, OPTIONS, HEAD, TRACE, CONNECT
}

// Mock implementation of HttpServletRequest for testing purposes
class MockHttpServletRequest implements HttpServletRequest {
    private final String method;
    private final String requestURI;

    public MockHttpServletRequest(String method, String requestURI) {
        this.method = method;
        this.requestURI = requestURI;
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public String getRequestURI() {
        return requestURI;
    }

    // Implement other methods from HttpServletRequest as needed
    // For simplicity, you can throw UnsupportedOperationException for unimplemented methods
    // ... (other methods are omitted for brevity)
}