import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

public class Temp667 {
    public static void main(String[] args) {
        String username = "user";
        String password = "pass";
        HttpServletResponse response = new MockHttpServletResponse();
        
        String url = "j_security_check?j_username=" + username + "&amp;j_password=" + password;
        String redirectUrl = response.encodeRedirectURL(url);
        
        try {
            response.sendRedirect(redirectUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MockHttpServletResponse implements HttpServletResponse {
    @Override
    public String encodeRedirectURL(String url) {
        return url.replace("&amp;", "&");
    }

    @Override
    public void sendRedirect(String location) throws IOException {
        System.out.println("Redirecting to: " + location);
    }

    // Implement other methods from HttpServletResponse as needed
    // For simplicity, these methods can be left blank or throw UnsupportedOperationException
    @Override public void addCookie(javax.servlet.http.Cookie cookie) {}
    @Override public boolean containsHeader(String name) { return false; }
    @Override public String encodeURL(String url) { return null; }
    @Override public void sendError(int sc, String msg) throws IOException {}
    @Override public void sendError(int sc) throws IOException {}
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
    @Override public javax.servlet.ServletOutputStream getOutputStream() throws java.io.IOException { return null; }
    @Override public java.io.PrintWriter getWriter() throws java.io.IOException { return null; }
    @Override public void setCharacterEncoding(java.lang.String charset) {}
    @Override public void setContentLength(int len) {}
    @Override public void setContentLengthLong(long len) {}
    @Override public void setContentType(java.lang.String type) {}
    @Override public void setBufferSize(int size) {}
    @Override public int getBufferSize() { return 0; }
    @Override public void flushBuffer() throws java.io.IOException {}
    @Override public void resetBuffer() {}
    @Override public boolean isCommitted() { return false; }
    @Override public void reset() {}
    @Override public void setLocale(java.util.Locale loc) {}
    @Override public java.util.Locale getLocale() { return null; }
}