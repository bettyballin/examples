import javax.servlet.http.HttpServletRequest;

public class Temp197 {
    public static void main(String[] args) {
        // Example usage with a mock HttpServletRequest
        HttpServletRequest request = new MockHttpServletRequest();
        Object principal = new Temp197().getPreAuthenticatedPrincipal(request);
        System.out.println("Principal: " + principal);
    }

    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return request.getHeader("SM_USER");
    }

    // Mock implementation of HttpServletRequest for demonstration purposes
    static class MockHttpServletRequest implements HttpServletRequest {
        @Override
        public String getHeader(String name) {
            if ("SM_USER".equals(name)) {
                return "testUser";
            }
            return null;
        }

        @Override
        public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getAuthType() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public Cookie[] getCookies() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public long getDateHeader(String name) {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getHeaderNames() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public Enumeration getHeaders(String name) {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public int getIntHeader(String name) {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getMethod() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getPathInfo() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getPathTranslated() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getContextPath() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getQueryString() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getRemoteUser() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public boolean isUserInRole(String role) {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public Principal getUserPrincipal() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getRequestedSessionId() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getRequestURI() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public StringBuffer getRequestURL() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getServletPath() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public HttpSession getSession(boolean create) {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public HttpSession getSession() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public boolean isRequestedSessionIdValid() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public boolean isRequestedSessionIdFromCookie() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public boolean isRequestedSessionIdFromURL() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public boolean isRequestedSessionIdFromUrl() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public boolean authenticate(HttpServletResponse response, HttpSession session) throws IOException, ServletException {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public void login(String username, String password) throws ServletException {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public void logout() throws ServletException {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public Collection getParts() throws IOException, ServletException {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public Part getPart(String name) throws IOException, ServletException {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, ServletException {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public Object getAttribute(String name) {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public Enumeration getAttributeNames() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getCharacterEncoding() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public int getContentLength() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getContentType() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getParameter(String name) {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public Enumeration getParameterNames() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String[] getParameterValues(String name) {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public Map getParameterMap() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getProtocol() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getScheme() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getServerName() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public int getServerPort() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public BufferedReader getReader() throws IOException {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getRemoteAddr() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getRemoteHost() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public void setAttribute(String name, Object o) {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public void removeAttribute(String name) {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public Locale getLocale() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public Enumeration getLocales() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public boolean isSecure() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public RequestDispatcher getRequestDispatcher(String path) {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getRealPath(String path) {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public int getRemotePort() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getLocalName() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getLocalAddr() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public int getLocalPort() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public ServletContext getServletContext() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public AsyncContext startAsync() throws IllegalStateException {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public boolean isAsyncStarted() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public boolean isAsyncSupported() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public AsyncContext getAsyncContext() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public DispatcherType getDispatcherType() {
            throw new UnsupportedOperationException("Not implemented");
        }
    }
}