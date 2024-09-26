import javax.servlet.http.HttpServletRequest;

public class Temp2257 {

    public static void main(String[] args) {
        HttpServletRequest request = createMockRequest();
        Throwable throwable = new Throwable("Sample exception message");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String exceptionMessage = getExceptionMessage(throwable, statusCode);

        System.out.println("Status Code: " + statusCode);
        System.out.println("Exception Message: " + exceptionMessage);
    }

    private static String getExceptionMessage(Throwable throwable, Integer statusCode) {
        if (statusCode != null && statusCode == 404) {
            return "Resource not found";
        } else if (throwable != null) {
            return throwable.getMessage();
        } else {
            return "Unknown error";
        }
    }

    private static HttpServletRequest createMockRequest() {
        HttpServletRequest request = new HttpServletRequest() {
            @Override
            public Object getAttribute(String name) {
                if ("javax.servlet.error.status_code".equals(name)) {
                    return 404;
                }
                return null;
            }

            // Other methods not implemented for brevity
            @Override public String getAuthType() { return null; }
            @Override public Cookie[] getCookies() { return new Cookie[0]; }
            @Override public long getDateHeader(String name) { return 0; }
            @Override public String getHeader(String name) { return null; }
            @Override public Enumeration<String> getHeaders(String name) { return null; }
            @Override public Enumeration<String> getHeaderNames() { return null; }
            @Override public int getIntHeader(String name) { return 0; }
            @Override public String getMethod() { return null; }
            @Override public String getPathInfo() { return null; }
            @Override public String getPathTranslated() { return null; }
            @Override public String getContextPath() { return null; }
            @Override public String getQueryString() { return null; }
            @Override public String getRemoteUser() { return null; }
            @Override public boolean isUserInRole(String role) { return false; }
            @Override public Principal getUserPrincipal() { return null; }
            @Override public String getRequestedSessionId() { return null; }
            @Override public String getRequestURI() { return null; }
            @Override public StringBuffer getRequestURL() { return null; }
            @Override public String getServletPath() { return null; }
            @Override public HttpSession getSession(boolean create) { return null; }
            @Override public HttpSession getSession() { return null; }
            @Override public String changeSessionId() { return null; }
            @Override public boolean isRequestedSessionIdValid() { return false; }
            @Override public boolean isRequestedSessionIdFromCookie() { return false; }
            @Override public boolean isRequestedSessionIdFromURL() { return false; }
            @Override public boolean isRequestedSessionIdFromUrl() { return false; }
            @Override public boolean authenticate(HttpServletResponse response) { return false; }
            @Override public void login(String username, String password) {}
            @Override public void logout() {}
            @Override public Collection<Part> getParts() { return null; }
            @Override public Part getPart(String name) { return null; }
            @Override public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) { return null; }
            @Override public Object getAttribute(String name, Class<?> type) { return null; }
            @Override public AsyncContext getAsyncContext() { return null; }
            @Override public DispatcherType getDispatcherType() { return null; }
            @Override public ServletContext getServletContext() { return null; }
            @Override public boolean isAsyncStarted() { return false; }
            @Override public boolean isAsyncSupported() { return false; }
            @Override public AsyncContext startAsync() { return null; }
            @Override public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) { return null; }
            @Override public void setCharacterEncoding(String env) {}
            @Override public int getContentLength() { return 0; }
            @Override public long getContentLengthLong() { return 0; }
            @Override public String getContentType() { return null; }
            @Override public ServletInputStream getInputStream() { return null; }
            @Override public String getParameter(String name) { return null; }
            @Override public Enumeration<String> getParameterNames() { return null; }
            @Override public String[] getParameterValues(String name) { return new String[0]; }
            @Override public Map<String, String[]> get