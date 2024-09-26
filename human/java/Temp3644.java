import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class Temp3644 {

    private final RequestMatcher uriMatcher = new AntPathRequestMatcher("/api/v0/auth/login", HttpMethod.GET.name());

    public static void main(String[] args) {
        // Sample HttpServletRequest for testing
        HttpServletRequest request = new MockHttpServletRequest("GET", "/api/v0/auth/login");
        Temp3644 temp = new Temp3644();
        boolean result = temp.shouldNotFilter(request);
        System.out.println("Should not filter: " + result);
    }

    protected boolean shouldNotFilter(HttpServletRequest request) {
        return uriMatcher.matches(request);
    }

    // MockHttpServletRequest for testing purposes
    static class MockHttpServletRequest implements HttpServletRequest {
        private String method;
        private String requestURI;

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
        // For brevity, these methods are either not implemented or return default values

        @Override
        public String getAuthType() { return null; }
        @Override
        public String getContextPath() { return null; }
        @Override
        public Cookie[] getCookies() { return new Cookie[0]; }
        @Override
        public long getDateHeader(String name) { return 0; }
        @Override
        public String getHeader(String name) { return null; }
        @Override
        public Enumeration<String> getHeaderNames() { return null; }
        @Override
        public Enumeration<String> getHeaders(String name) { return null; }
        @Override
        public int getIntHeader(String name) { return 0; }
        @Override
        public String getPathInfo() { return null; }
        @Override
        public String getPathTranslated() { return null; }
        @Override
        public String getQueryString() { return null; }
        @Override
        public String getRemoteUser() { return null; }
        @Override
        public String getRequestedSessionId() { return null; }
        @Override
        public String getServletPath() { return null; }
        @Override
        public HttpSession getSession() { return null; }
        @Override
        public HttpSession getSession(boolean create) { return null; }
        @Override
        public Principal getUserPrincipal() { return null; }
        @Override
        public boolean isRequestedSessionIdFromCookie() { return false; }
        @Override
        public boolean isRequestedSessionIdFromURL() { return false; }
        @Override
        public boolean isRequestedSessionIdFromUrl() { return false; }
        @Override
        public boolean isRequestedSessionIdValid() { return false; }
        @Override
        public boolean isUserInRole(String role) { return false; }
        @Override
        public Object getAttribute(String name) { return null; }
        @Override
        public Enumeration<String> getAttributeNames() { return null; }
        @Override
        public String getCharacterEncoding() { return null; }
        @Override
        public int getContentLength() { return 0; }
        @Override
        public long getContentLengthLong() { return 0; }
        @Override
        public String getContentType() { return null; }
        @Override
        public ServletInputStream getInputStream() { return null; }
        @Override
        public String getLocalAddr() { return null; }
        @Override
        public String getLocalName() { return null; }
        @Override
        public int getLocalPort() { return 0; }
        @Override
        public Locale getLocale() { return null; }
        @Override
        public Enumeration<Locale> getLocales() { return null; }
        @Override
        public String getParameter(String name) { return null; }
        @Override
        public Map<String, String[]> getParameterMap() { return null; }
        @Override
        public Enumeration<String> getParameterNames() { return null; }
        @Override
        public String[] getParameterValues(String name) { return new String[0]; }
        @Override
        public String getProtocol() { return null; }
        @Override
        public BufferedReader getReader() { return null; }
        @Override
        public String getReal