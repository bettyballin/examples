import javax.servlet.http.HttpServletRequest;

public class Temp697 {

    public static void main(String[] args) {
        // For demonstration purposes, creating a mock HttpServletRequest
        HttpServletRequest request = new MockHttpServletRequest();
        String userAgent = request.getHeader("User-Agent");
        System.out.println(userAgent);
    }
}

// Mock implementation of HttpServletRequest for demonstration purposes
class MockHttpServletRequest implements HttpServletRequest {

    @Override
    public String getHeader(String name) {
        if ("User-Agent".equals(name)) {
            return "Mock User-Agent";
        }
        return null;
    }

    // All other methods from HttpServletRequest can throw UnsupportedOperationException
    // or return default values for simplicity in this mock class
    @Override
    public Object getAttribute(String name) { throw new UnsupportedOperationException(); }
    @Override
    public Enumeration<String> getAttributeNames() { throw new UnsupportedOperationException(); }
    @Override
    public String getCharacterEncoding() { throw new UnsupportedOperationException(); }
    @Override
    public void setCharacterEncoding(String env) throws UnsupportedEncodingException { throw new UnsupportedOperationException(); }
    @Override
    public int getContentLength() { throw new UnsupportedOperationException(); }
    @Override
    public long getContentLengthLong() { throw new UnsupportedOperationException(); }
    @Override
    public String getContentType() { throw new UnsupportedOperationException(); }
    @Override
    public ServletInputStream getInputStream() throws IOException { throw new UnsupportedOperationException(); }
    @Override
    public String getParameter(String name) { throw new UnsupportedOperationException(); }
    @Override
    public Enumeration<String> getParameterNames() { throw new UnsupportedOperationException(); }
    @Override
    public String[] getParameterValues(String name) { throw new UnsupportedOperationException(); }
    @Override
    public Map<String, String[]> getParameterMap() { throw new UnsupportedOperationException(); }
    @Override
    public String getProtocol() { throw new UnsupportedOperationException(); }
    @Override
    public String getScheme() { throw new UnsupportedOperationException(); }
    @Override
    public String getServerName() { throw new UnsupportedOperationException(); }
    @Override
    public int getServerPort() { throw new UnsupportedOperationException(); }
    @Override
    public BufferedReader getReader() throws IOException { throw new UnsupportedOperationException(); }
    @Override
    public String getRemoteAddr() { throw new UnsupportedOperationException(); }
    @Override
    public String getRemoteHost() { throw new UnsupportedOperationException(); }
    @Override
    public void setAttribute(String name, Object o) { throw new UnsupportedOperationException(); }
    @Override
    public void removeAttribute(String name) { throw new UnsupportedOperationException(); }
    @Override
    public Locale getLocale() { throw new UnsupportedOperationException(); }
    @Override
    public Enumeration<Locale> getLocales() { throw new UnsupportedOperationException(); }
    @Override
    public boolean isSecure() { throw new UnsupportedOperationException(); }
    @Override
    public RequestDispatcher getRequestDispatcher(String path) { throw new UnsupportedOperationException(); }
    @Override
    public String getRealPath(String path) { throw new UnsupportedOperationException(); }
    @Override
    public int getRemotePort() { throw new UnsupportedOperationException(); }
    @Override
    public String getLocalName() { throw new UnsupportedOperationException(); }
    @Override
    public String getLocalAddr() { throw new UnsupportedOperationException(); }
    @Override
    public int getLocalPort() { throw new UnsupportedOperationException(); }
    @Override
    public ServletContext getServletContext() { throw new UnsupportedOperationException(); }
    @Override
    public AsyncContext startAsync() throws IllegalStateException { throw new UnsupportedOperationException(); }
    @Override
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException { throw new UnsupportedOperationException(); }
    @Override
    public boolean isAsyncStarted() { throw new UnsupportedOperationException(); }
    @Override
    public boolean isAsyncSupported() { throw new UnsupportedOperationException(); }
    @Override
    public AsyncContext getAsyncContext() { throw new UnsupportedOperationException(); }
    @Override
    public DispatcherType getDispatcherType() { throw new UnsupportedOperationException(); }

    // Add additional required methods with default implementations if necessary
}