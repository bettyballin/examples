import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.DispatcherType;
import javax.servlet.AsyncContext;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Cookie;
import javax.servlet.http.Principal;
import javax.servlet.http.HttpServletRequestWrapper;

import java.util.Enumeration;
import java.util.Collection;

import org.springframework.security.web.util.matcher.RequestMatcher;

public class CustomRequestMatcher implements RequestMatcher {
    @Override
    public boolean matches(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        return servletPath != null && servletPath.startsWith("/swagger-ui/");
    }

    public static void main(String[] args) {
        // Sample test
        HttpServletRequest request = new MockHttpServletRequest("/swagger-ui/index.html");
        CustomRequestMatcher matcher = new CustomRequestMatcher();
        System.out.println(matcher.matches(request)); // Should print true
    }
}

class MockHttpServletRequest implements HttpServletRequest {
    private String servletPath;

    public MockHttpServletRequest(String servletPath) {
        this.servletPath = servletPath;
    }

    @Override
    public String getServletPath() {
        return this.servletPath;
    }

    // Implement other methods from HttpServletRequest as no-op or return default values
    @Override
    public Object getAttribute(String s) { return null; }
    @Override
    public String getAuthType() { return null; }
    @Override
    public Cookie[] getCookies() { return new Cookie[0]; }
    @Override
    public long getDateHeader(String s) { return 0; }
    @Override
    public String getHeader(String s) { return null; }
    @Override
    public Enumeration<String> getHeaders(String s) { return null; }
    @Override
    public Enumeration<String> getHeaderNames() { return null; }
    @Override
    public int getIntHeader(String s) { return 0; }
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
    public boolean isUserInRole(String s) { return false; }
    @Override
    public Principal getUserPrincipal() { return null; }
    @Override
    public String getRequestedSessionId() { return null; }
    @Override
    public String getRequestURI() { return null; }
    @Override
    public StringBuffer getRequestURL() { return null; }
    @Override
    public HttpSession getSession(boolean b) { return null; }
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
    public boolean authenticate(HttpServletResponse httpServletResponse) { return false; }
    @Override
    public void login(String s, String s1) {}
    @Override
    public void logout() {}
    @Override
    public Collection<Part> getParts() { return null; }
    @Override
    public Part getPart(String s) { return null; }
    @Override
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> aClass) { return null; }

    // Implement other methods from ServletRequest as no-op or return default values
    @Override
    public AsyncContext startAsync() { return null; }
    @Override
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) { return null; }
    @Override
    public boolean isAsyncStarted() { return false; }
    @Override
    public boolean isAsyncSupported() { return false; }
    @Override
    public AsyncContext getAsyncContext() { return null; }
    @Override
    public DispatcherType getDispatcherType() { return null; }
    @Override
    public String getCharacterEncoding() { return null; }
    @Override
    public void setCharacterEncoding(String s) {}
    @Override
    public int getContentLength() { return 0; }
    @Override
    public long getContentLengthLong() { return 0; }
    @Override
    public String getContentType() { return null; }
    @Override
    public ServletInputStream getInputStream() { return null; }
    @Override
    public String getParameter(String s) { return null; }
    @Override
    public Enumeration<String> getParameterNames() { return null; }
    @Override
    public String[] getParameterValues(String s) { return new String[0]; }
    @Override
    public Map<String, String[]> getParameterMap() { return null; }
    @Override
    public String getProtocol() { return null; }
    @Override
    public String getScheme() { return null; }
    @Override
    public String getServerName() { return null; }
    @Override
    public int getServerPort() { return 0; }
    @Override
    public BufferedReader getReader() { return null; }
    @Override
    public String getRemoteAddr() { return null; }
    @Override
    public String getRemoteHost() { return null; }
    @Override
    public void setAttribute(String s, Object o) {}
    @Override
    public void removeAttribute(String s) {}
    @Override
    public Locale getLocale() { return null; }
    @Override
    public Enumeration<Locale> getLocales() { return null; }
    @Override
    public boolean isSecure() { return false; }
    @Override
    public RequestDispatcher getRequestDispatcher(String s) { return null; }
    @Override
    public String getRealPath(String s) { return null; }
    @Override
    public int getRemotePort() { return 0; }
    @Override
    public String getLocalName() { return null; }
    @Override
    public String getLocalAddr() { return null; }
    @Override
    public int getLocalPort() { return 0; }
}