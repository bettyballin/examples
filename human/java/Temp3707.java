import javax.servlet.http.HttpServletRequest;

public class Temp3707 {
    public static void main(String[] args) {
        // Simulate a HttpServletRequest (you would normally get this from a servlet container)
        HttpServletRequest request = new MockHttpServletRequest("GET", "/examplePath");
        
        // Assuming a method getParsedRequestPath is defined in ServletRequestPathUtils
        String pathWithinApplication = ServletRequestPathUtils.getParsedRequestPath(request).pathWithinApplication();

        // Print the result
        System.out.println(pathWithinApplication);
    }
}

class ServletRequestPathUtils {
    public static ParsedRequestPath getParsedRequestPath(HttpServletRequest request) {
        // Mock parsing logic
        return new ParsedRequestPath(request.getRequestURI());
    }
}

class ParsedRequestPath {
    private String path;

    public ParsedRequestPath(String path) {
        this.path = path;
    }

    public String pathWithinApplication() {
        // Return the path within the application context
        return this.path;
    }
}

// MockHttpServletRequest to simulate HttpServletRequest
class MockHttpServletRequest implements HttpServletRequest {
    private String method;
    private String requestURI;

    public MockHttpServletRequest(String method, String requestURI) {
        this.method = method;
        this.requestURI = requestURI;
    }

    @Override
    public String getRequestURI() {
        return this.requestURI;
    }

    // Implement other methods from HttpServletRequest with default or mock behavior
    // (Omitted for brevity)
}