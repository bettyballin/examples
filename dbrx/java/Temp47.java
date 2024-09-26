import javax.servlet.http.HttpServletRequest;

public class Temp47 {
    public static void main(String[] args) {
        // Simulate a request (in actual use, this would be provided by the servlet container)
        HttpServletRequest request = new MockHttpServletRequest();
        
        // Assuming the parameter "ticket" will be present in the request
        String casTicket = request.getParameter("ticket");
        
        // Print the ticket value for demonstration
        System.out.println("CAS Ticket: " + casTicket);
    }
}

// Mock HttpServletRequest for demonstration purposes
class MockHttpServletRequest implements HttpServletRequest {
    // Implement only the methods we need for this demonstration
    @Override
    public String getParameter(String name) {
        if ("ticket".equals(name)) {
            return "sampleTicketValue";
        }
        return null;
    }

    // Other methods would need to be implemented for a full mock, but are omitted for brevity
    // ...
    
    @Override
    public Object getAttribute(String name) { return null; }
    @Override
    public Enumeration<String> getAttributeNames() { return null; }
    @Override
    public String getCharacterEncoding() { return null; }
    @Override
    public void setCharacterEncoding(String env) throws UnsupportedEncodingException {}
    @Override
    public int getContentLength() { return 0; }
    @Override
    public long getContentLengthLong() { return 0; }
    @Override
    public String getContentType() { return null; }
    @Override
    public ServletInputStream getInputStream() throws IOException { return null; }
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
    @Override
    public String getServerName() { return null; }
    @Override
    public int getServerPort() { return 0; }
    @Override
    public BufferedReader getReader() throws IOException { return null; }
    @Override
    public String getRemoteAddr() { return null; }
    @Override
    public String getRemoteHost() { return null; }
    @Override
    public void setAttribute(String name, Object o) {}
    @Override
    public void removeAttribute(String name) {}
    @Override
    public Locale getLocale() { return null; }
    @Override
    public Enumeration<Locale> getLocales() { return null; }
    @Override
    public boolean isSecure() { return false; }
    @Override
    public RequestDispatcher getRequestDispatcher(String path) { return null; }
    @Override
    public String getRealPath(String path) { return null; }
    @Override
    public int getRemotePort() { return 0; }
    @Override
    public String getLocalName() { return null; }
    @Override
    public String getLocalAddr() { return null; }
    @Override
    public int getLocalPort() { return 0; }
    @Override
    public ServletContext getServletContext() { return null; }
    @Override
    public AsyncContext startAsync() throws IllegalStateException { return null; }
    @Override
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException { return null; }
    @Override
    public boolean isAsyncStarted() { return false; }
    @Override
    public boolean isAsyncSupported() { return false; }
    @Override
    public AsyncContext getAsyncContext() { return null; }
    @Override
    public DispatcherType getDispatcherType() { return null; }
}