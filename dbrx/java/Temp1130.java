import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;

public class Temp1130 {
    public static void main(String[] args) {
        LogoutHandler logoutHandler = new LogoutHandler() {
            @Override
            public void logout(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.Authentication authentication) {
                System.out.println("Custom logout handler executed.");
            }
        };

        AntPathRequestMatcher logoutRequestMatcher = new AntPathRequestMatcher("/logout");

        HttpServletRequest request = new MockHttpServletRequest();
        HttpServletResponse response = new MockHttpServletResponse();

        if (logoutRequestMatcher.matches(request)) {
            logoutHandler.logout(request, response, null);

            boolean invalidateHttpSession = false;
            boolean clearAuthentication = false;

            if (invalidateHttpSession) {
                System.out.println("HTTP session invalidated.");
            }
            if (clearAuthentication) {
                System.out.println("Authentication cleared.");
            }
        } else {
            System.out.println("No logout request matched.");
        }
    }

    static class MockHttpServletRequest implements HttpServletRequest {
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
        public String getRequestURI() { return "/logout"; }
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
        public void login(String username, String password) throws ServletException { }
        @Override
        public void logout() throws ServletException { }
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
    }

    static class MockHttpServletResponse implements HttpServletResponse {
        @Override
        public void addCookie(Cookie cookie) { }
        @Override
        public boolean containsHeader(String name) { return false; }
        @Override
        public String encodeURL(String url) { return null; }
        @Override
        public String encodeRedirectURL(String url) { return null; }
        @Override
        public String encodeUrl(String url) { return null; }
        @Override
        public String encodeRedirectUrl(String url) { return null; }
        @Override
        public void sendError(int sc, String msg) throws IOException { }
        @Override
        public void sendError(int sc) throws IOException { }
        @Override
        public void sendRedirect(String location) throws IOException { }
        @Override
        public void setDateHeader(String name, long date) { }
        @Override
        public void addDateHeader(String name, long date) { }
        @Override
        public void setHeader(String name, String value) { }
        @Override
        public void addHeader(String name, String value) { }
        @Override
        public void setIntHeader(String name, int value) { }
        @Override
        public void addIntHeader(String name, int value) { }
        @Override
        public void setStatus(int sc) { }
        @Override
        public void setStatus(int sc, String sm) { }
        @Override
        public int getStatus() { return 0; }
        @Override
        public String getHeader(String name) { return null; }
        @Override
        public Collection<String> getHeaders(String name) { return null; }
        @Override
        public Collection<String> getHeaderNames() { return null; }
        @Override
        public String getCharacterEncoding() { return null; }
        @Override
        public String getContentType() { return null; }
        @Override
        public ServletOutputStream getOutputStream() throws IOException { return null; }
        @Override
        public PrintWriter getWriter() throws IOException { return null; }
        @Override
        public void setCharacterEncoding(String charset) { }
        @Override
        public void setContentLength(int len) { }
        @Override
        public void setContentType(String type) { }
        @Override
        public void setBufferSize(int size) { }
        @Override
        public int getBufferSize() { return 0; }
        @Override
        public void flushBuffer() throws IOException { }
        @Override
        public void resetBuffer() { }
        @Override
        public boolean isCommitted() { return false; }
        @Override
        public void reset() { }
        @Override
        public void setLocale(Locale loc) { }
        @Override
        public Locale getLocale() { return null; }
    }
}