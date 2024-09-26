import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;

class CustomMethodDetails implements Serializable {
    private String methodName;

    public CustomMethodDetails(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}

abstract class PreAuthenticatedProcessingFilter {
    protected abstract Object getPreAuthenticatedCredentials(HttpServletRequest request);
}

public class MyPreAuthenticatedProcessingFilter extends PreAuthenticatedProcessingFilter {

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return new CustomMethodDetails(extractMethodName(request));
    }

    private String extractMethodName(HttpServletRequest request) {
        // Mock implementation for demonstration purposes.
        return request.getMethod();
    }

    public static void main(String[] args) {
        // Test the implementation.
        HttpServletRequest request = new MockHttpServletRequest("GET", "/example");
        MyPreAuthenticatedProcessingFilter filter = new MyPreAuthenticatedProcessingFilter();
        CustomMethodDetails details = (CustomMethodDetails) filter.getPreAuthenticatedCredentials(request);
        System.out.println("Method Name: " + details.getMethodName());
    }
}

// Mock implementation of HttpServletRequest for testing.
class MockHttpServletRequest implements HttpServletRequest {
    private String method;
    private String requestURI;

    public MockHttpServletRequest(String method, String requestURI) {
        this.method = method;
        this.requestURI = requestURI;
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public String getRequestURI() {
        return this.requestURI;
    }

    @Override
    public String getContextPath() {
        return "";
    }

    @Override
    public String getQueryString() {
        return "";
    }

    @Override
    public String getRemoteUser() {
        return "";
    }

    @Override
    public boolean isUserInRole(String role) {
        return false;
    }

    @Override
    public java.security.Principal getUserPrincipal() {
        return null;
    }

    @Override
    public String getRequestedSessionId() {
        return "";
    }

    @Override
    public String changeSessionId() {
        return "";
    }

    @Override
    public boolean isRequestedSessionIdValid() {
        return false;
    }

    @Override
    public boolean isRequestedSessionIdFromCookie() {
        return false;
    }

    @Override
    public boolean isRequestedSessionIdFromURL() {
        return false;
    }

    @Override
    public boolean isRequestedSessionIdFromUrl() {
        return false;
    }

    @Override
    public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
        return false;
    }

    @Override
    public void login(String username, String password) throws ServletException {
    }

    @Override
    public void logout() throws ServletException {
    }

    @Override
    public Collection<Part> getParts() throws IOException, ServletException {
        return Collections.emptyList();
    }

    @Override
    public Part getPart(String name) throws IOException, ServletException {
        return null;
    }

    @Override
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, ServletException {
        return null;
    }
}