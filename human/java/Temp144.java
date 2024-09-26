import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.servlet.http.HttpServletRequest;

public class Temp144 {
    public static void main(String[] args) {
        // Simulating an HttpServletRequest
        HttpServletRequest request = new MockHttpServletRequest();
        String text = request.getParameter("text");
        String safe = Jsoup.clean(text, Whitelist.basic());
        
        // Persist 'safe' in DB instead (just printing for demonstration)
        System.out.println(safe);
    }
}

// A simple mock HttpServletRequest for demonstration purposes
class MockHttpServletRequest implements HttpServletRequest {
    public String getParameter(String name) {
        if ("text".equals(name)) {
            return "<script>alert('Hello');</script>";
        }
        return null;
    }

    // Other methods from HttpServletRequest can be left unimplemented for brevity
    public java.util.Collection<javax.servlet.http.Part> getParts() { return null; }
    public javax.servlet.http.Part getPart(String name) { return null; }
    public Object getAttribute(String name) { return null; }
    public java.util.Enumeration<String> getAttributeNames() { return null; }
    public java.lang.String getCharacterEncoding() { return null; }
    public void setCharacterEncoding(java.lang.String env) { }
    public int getContentLength() { return 0; }
    public long getContentLengthLong() { return 0; }
    public java.lang.String getContentType() { return null; }
    public javax.servlet.ServletInputStream getInputStream() { return null; }
    public java.util.Locale getLocale() { return null; }
    public java.util.Enumeration<java.util.Locale> getLocales() { return null; }
    public java.lang.String getParameter(java.lang.String name) { return null; }
    public java.util.Map<java.lang.String,java.lang.String[]> getParameterMap() { return null; }
    public java.util.Enumeration<java.lang.String> getParameterNames() { return null; }
    public java.lang.String[] getParameterValues(java.lang.String name) { return null; }
    public java.io.BufferedReader getReader() { return null; }
    public java.lang.String getRemoteAddr() { return null; }
    public java.lang.String getRemoteHost() { return null; }
    public void setAttribute(java.lang.String name, java.lang.Object o) { }
    public void removeAttribute(java.lang.String name) { }
    public javax.servlet.RequestDispatcher getRequestDispatcher(java.lang.String path) { return null; }
    public java.lang.String getRealPath(java.lang.String path) { return null; }
    public int getRemotePort() { return 0; }
    public java.lang.String getLocalName() { return null; }
    public java.lang.String getLocalAddr() { return null; }
    public int getLocalPort() { return 0; }
    public javax.servlet.ServletContext getServletContext() { return null; }
    public javax.servlet.AsyncContext startAsync() { return null; }
    public javax.servlet.AsyncContext startAsync(javax.servlet.ServletRequest servletRequest, javax.servlet.ServletResponse servletResponse) { return null; }
    public boolean isAsyncStarted() { return false; }
    public boolean isAsyncSupported() { return false; }
    public javax.servlet.AsyncContext getAsyncContext() { return null; }
    public javax.servlet.DispatcherType getDispatcherType() { return null; }
    public java.lang.String getAuthType() { return null; }
    public javax.servlet.http.Cookie[] getCookies() { return new javax.servlet.http.Cookie[0]; }
    public long getDateHeader(java.lang.String name) { return 0; }
    public java.lang.String getHeader(java.lang.String name) { return null; }
    public java.util.Enumeration<java.lang.String> getHeaders(java.lang.String name) { return null; }
    public java.util.Enumeration<java.lang.String> getHeaderNames() { return null; }
    public int getIntHeader(java.lang.String name) { return 0; }
    public java.lang.String getMethod() { return null; }
    public java.lang.String getPathInfo() { return null; }
    public java.lang.String getPathTranslated() { return null; }
    public java.lang.String getContextPath() { return null; }
    public java.lang.String getQueryString() { return null; }
    public java.lang.String getRemoteUser() { return null; }
    public boolean isUserInRole(java.lang.String role) { return false; }
    public java.security.Principal getUserPrincipal() { return null; }
    public java.lang.String getRequestedSessionId() { return null; }
    public java.lang.String getRequestURI() { return null; }
    public java.lang.StringBuffer getRequestURL() { return null; }