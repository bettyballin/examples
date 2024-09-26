import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;

// Assuming CustomTokenAuthentication is a class that you have defined.
public class CustomTokenFilter extends AbstractPreAuthenticatedProcessingFilter {
    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        String authorization = request.getHeader("authorization");

        if (authorization != null && authorization.startsWith("Custom ")) {
            return new CustomTokenAuthentication(authorization);
        }

        return null;
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return "";
    }

    // Main method to test the filter
    public static void main(String[] args) {
        // Simulation of a request with "authorization" header
        HttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("authorization", "Custom token123");

        CustomTokenFilter filter = new CustomTokenFilter();
        Object principal = filter.getPreAuthenticatedPrincipal(request);
        Object credentials = filter.getPreAuthenticatedCredentials(request);

        System.out.println("Principal: " + principal);
        System.out.println("Credentials: " + credentials);
    }
}

// Mock classes for testing
class CustomTokenAuthentication {
    private String token;

    public CustomTokenAuthentication(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "CustomTokenAuthentication{token='" + token + "'}";
    }
}

class MockHttpServletRequest implements HttpServletRequest {
    private final Map<String, String> headers = new HashMap<>();

    public void addHeader(String name, String value) {
        headers.put(name, value);
    }

    @Override
    public String getHeader(String name) {
        return headers.get(name);
    }

    // Implement other methods from HttpServletRequest with empty bodies or default return values
    // ...

    @Override
    public String getAuthType() { return null; }

    @Override
    public Cookie[] getCookies() { return new Cookie[0]; }

    @Override
    public long getDateHeader(String name) { return 0; }

    @Override
    public Enumeration<String> getHeaders(String name) { return Collections.enumeration(headers.values()); }

    @Override
    public Enumeration<String> getHeaderNames() { return Collections.enumeration(headers.keySet()); }

    @Override
    public int getIntHeader(String name) { return 0; }

    @Override
    public String getMethod() { return null; }

    @Override
    public String getPathInfo() { return null; }

    @Override
    public String getPathTranslated() { return null; }

    @Override
    public String getContextPath() { return null; }

    @Override
    public String getQueryString() { return null; }

    @Override
    public String getRemoteUser() { return null; }

    @Override
    public boolean isUserInRole(String role) { return false; }

    @Override
    public Principal getUserPrincipal() { return null; }

    @Override
    public String getRequestedSessionId() { return null; }

    @Override
    public String getRequestURI() { return null; }

    @Override
    public StringBuffer getRequestURL() { return null; }

    @Override
    public String getServletPath() { return null; }

    @Override
    public HttpSession getSession(boolean create) { return null; }

    @Override
    public HttpSession getSession() { return null; }

    @Override
    public String changeSessionId() { return null; }

    @Override
    public boolean isRequestedSessionIdValid() { return false; }

    @Override
    public boolean isRequestedSessionIdFromCookie() { return false; }

    @Override
    public boolean isRequestedSessionIdFromURL() { return false; }

    @Override
    public boolean isRequestedSessionIdFromUrl() { return false; }

    @Override
    public boolean authenticate(HttpServletResponse response) throws IOException, ServletException { return false; }

    @Override
    public void login(String username, String password) throws ServletException {}

    @Override
    public void logout() throws ServletException {}

    @Override
    public Collection<Part> getParts() throws IOException, ServletException { return null; }

    @Override
    public Part getPart(String name) throws IOException, ServletException { return null; }

    @Override
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, ServletException { return null; }

    @Override
    public Object getAttribute(String name) { return null; }

    @Override
    public Enumeration<String> getAttributeNames() { return null; }

    @Override
    public