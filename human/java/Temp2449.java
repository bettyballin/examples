import javax.servlet.ServletRequest;

public class Temp2449 {
    public static void main(String[] args) {
        // Since we cannot instantiate ServletRequest directly, we'll create a mock object for demonstration purposes.
        ServletRequest request = new MockServletRequest();

        System.out.println("Local Hostname: " + request.getLocalName());
        System.out.println("Local IP: " + request.getLocalAddr());
        System.out.println("Local Port: " + request.getLocalPort());
    }
}

// Creating a mock class to simulate ServletRequest for demonstration purposes.
class MockServletRequest implements ServletRequest {
    @Override
    public String getLocalName() {
        return "localhost";
    }

    @Override
    public String getLocalAddr() {
        return "127.0.0.1";
    }

    @Override
    public int getLocalPort() {
        return 8080;
    }

    // Other methods from ServletRequest interface would need to be implemented here.
    // For brevity, they are omitted.

    @Override public Object getAttribute(String name) { return null; }
    @Override public Enumeration<String> getAttributeNames() { return null; }
    @Override public String getCharacterEncoding() { return null; }
    @Override public void setCharacterEncoding(String env) { }
    @Override public int getContentLength() { return 0; }
    @Override public long getContentLengthLong() { return 0; }
    @Override public String getContentType() { return null; }
    @Override public ServletInputStream getInputStream() { return null; }
    @Override public String getParameter(String name) { return null; }
    @Override public Enumeration<String> getParameterNames() { return null; }
    @Override public String[] getParameterValues(String name) { return new String[0]; }
    @Override public Map<String, String[]> getParameterMap() { return null; }
    @Override public String getProtocol() { return null; }
    @Override public String getScheme() { return null; }
    @Override public String getServerName() { return null; }
    @Override public int getServerPort() { return 0; }
    @Override public BufferedReader getReader() { return null; }
    @Override public String getRemoteAddr() { return null; }
    @Override public String getRemoteHost() { return null; }
    @Override public void setAttribute(String name, Object o) { }
    @Override public void removeAttribute(String name) { }
    @Override public Locale getLocale() { return null; }
    @Override public Enumeration<Locale> getLocales() { return null; }
    @Override public boolean isSecure() { return false; }
    @Override public RequestDispatcher getRequestDispatcher(String path) { return null; }
    @Override public String getRealPath(String path) { return null; }
    @Override public int getRemotePort() { return 0; }
    @Override public String getLocalAddr() { return null; }
    @Override public String getLocalName() { return null; }
    @Override public ServletContext getServletContext() { return null; }
    @Override public AsyncContext startAsync() { return null; }
    @Override public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) { return null; }
    @Override public boolean isAsyncStarted() { return false; }
    @Override public boolean isAsyncSupported() { return false; }
    @Override public AsyncContext getAsyncContext() { return null; }
    @Override public DispatcherType getDispatcherType() { return null; }
}