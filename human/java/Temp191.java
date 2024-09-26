import javax.servlet.http.HttpServletResponse;

public class Temp191 {
    public static void main(String[] args) {
        // Simulating a servlet response object for demonstration purposes
        HttpServletResponse response = new MockHttpServletResponse();

        response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
        response.setHeader("Pragma", "no-cache"); //HTTP 1.0
        response.setDateHeader("Expires", 0); //prevent caching at the proxy server
    }
}

// Mock implementation of HttpServletResponse for demonstration purposes
class MockHttpServletResponse implements HttpServletResponse {
    // Implement required methods here or use a library like Mockito
    @Override public void setHeader(String name, String value) {
        System.out.println("Header set: " + name + " = " + value);
    }
    @Override public void setDateHeader(String name, long date) {
        System.out.println("Date header set: " + name + " = " + date);
    }

    // Other methods from HttpServletResponse must be overridden
    // For brevity, these methods can be left unimplemented or throw UnsupportedOperationException
    @Override public void addCookie(javax.servlet.http.Cookie cookie) {}
    @Override public boolean containsHeader(String name) { return false; }
    @Override public String encodeURL(String url) { return null; }
    @Override public String encodeRedirectURL(String url) { return null; }
    @Override public String encodeUrl(String url) { return null; }
    @Override public String encodeRedirectUrl(String url) { return null; }
    @Override public void sendError(int sc, String msg) {}
    @Override public void sendError(int sc) {}
    @Override public void sendRedirect(String location) {}
    @Override public void setDateHeader(String name, long date) {}
    @Override public void addDateHeader(String name, long date) {}
    @Override public void setHeader(String name, String value) {}
    @Override public void addHeader(String name, String value) {}
    @Override public void setIntHeader(String name, int value) {}
    @Override public void addIntHeader(String name, int value) {}
    @Override public void setStatus(int sc) {}
    @Override public void setStatus(int sc, String sm) {}
    @Override public int getStatus() { return 0; }
    @Override public String getHeader(String name) { return null; }
    @Override public java.util.Collection<String> getHeaders(String name) { return null; }
    @Override public java.util.Collection<String> getHeaderNames() { return null; }
    @Override public java.lang.String getCharacterEncoding() { return null; }
    @Override public java.lang.String getContentType() { return null; }
    @Override public javax.servlet.ServletOutputStream getOutputStream() { return null; }
    @Override public java.io.PrintWriter getWriter() { return null; }
    @Override public void setCharacterEncoding(java.lang.String charset) {}
    @Override public void setContentLength(int len) {}
    @Override public void setContentLengthLong(long len) {}
    @Override public void setContentType(java.lang.String type) {}
    @Override public void setBufferSize(int size) {}
    @Override public int getBufferSize() { return 0; }
    @Override public void flushBuffer() {}
    @Override public void resetBuffer() {}
    @Override public boolean isCommitted() { return false; }
    @Override public void reset() {}
    @Override public void setLocale(java.util.Locale loc) {}
    @Override public java.util.Locale getLocale() { return null; }
}