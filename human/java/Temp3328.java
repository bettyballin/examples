import org.owasp.esapi.ESAPI;

import javax.servlet.http.HttpServletRequest;

public class Temp3328 {

    public static void main(String[] args) {
        // Mock request
        HttpServletRequest request = new MockHttpServletRequest();
        
        // Get encoded version parameter
        String version = ESAPI.encoder().encodeForHTML(request.getParameter("version"));
        
        // Print the encoded version
        System.out.println(version);
    }
}

// MockHttpServletRequest class to simulate HttpServletRequest
class MockHttpServletRequest implements HttpServletRequest {
    // Implement required methods for HttpServletRequest here
    // For simplicity, only getParameter method is implemented
    
    @Override
    public String getParameter(String name) {
        if ("version".equals(name)) {
            return "1.0 <script>alert('test');</script>";
        }
        return null;
    }

    // Add all other unimplemented methods as no-op or return default values
    // ...

    @Override
    public String getAuthType() { return null; }
    @Override
    public Cookie[] getCookies() { return new Cookie[0]; }
    @Override
    public long getDateHeader(String name) { return 0; }
    @Override
    public String getHeader(String name) { return null; }
    @Override
    public Enumeration<String> getHeaders(String name) { return null; }
    @Override
    public Enumeration<String> getHeaderNames() { return null; }
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
    public boolean authenticate(HttpServletResponse response) { return false; }
    @Override
    public void login(String username, String password) {}
    @Override
    public void logout() {}
    @Override
    public Collection<Part> getParts() { return null; }
    @Override
    public Part getPart(String name) { return null; }
    @Override
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) { return null; }
    @Override
    public Object getAttribute(String name) { return null; }
    @Override
    public Enumeration<String> getAttributeNames() { return null; }
    @Override
    public String getCharacterEncoding() { return null; }
    @Override
    public void setCharacterEncoding(String env) {}
    @Override
    public int getContentLength() { return 0; }
    @Override
    public long getContentLengthLong() { return 0; }
    @Override
    public String getContentType() { return null; }
    @Override
    public ServletInputStream getInputStream() { return null; }
    @Override
    public String getParameter(String name) { return null; }
    @Override
    public Enumeration<String> getParameterNames() { return null; }
    @Override
    public String[] getParameterValues(String name) { return new String[0]; }
    @Override
    public Map<String, String[]> getParameterMap() { return null; }
    @Override
    public String getProtocol() { return null; }
    @Override
    public String getScheme() { return null; }
    @