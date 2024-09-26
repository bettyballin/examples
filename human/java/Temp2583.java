import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Temp2583 {

    public static void main(String[] args) {
        Temp2583 temp = new Temp2583();
        temp.exceptionHandling().authenticationEntryPoint((request, response, authException) -> {
            response.addHeader(HttpHeaders.WWW_AUTHENTICATE, "Basic realm=\"Restricted Content\"");
            response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
        });
    }

    public Temp2583 exceptionHandling() {
        return this;
    }

    public Temp2583 authenticationEntryPoint(AuthenticationEntryPoint entryPoint) {
        // Simulate the execution of the entry point
        try {
            HttpServletRequest request = null;  // Normally, you'd get these from the web framework
            HttpServletResponse response = new MockHttpServletResponse();
            entryPoint.commence(request, response, new RuntimeException("Unauthorized"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    @FunctionalInterface
    interface AuthenticationEntryPoint {
        void commence(HttpServletRequest request, HttpServletResponse response, Exception authException) throws IOException;
    }

    // A simple mock HttpServletResponse for demonstration purposes
    static class MockHttpServletResponse implements HttpServletResponse {
        @Override
        public void addHeader(String name, String value) {
            System.out.println("Header added: " + name + " = " + value);
        }

        @Override
        public void sendError(int sc, String msg) throws IOException {
            System.out.println("Error sent: " + sc + " - " + msg);
        }

        // Other methods from HttpServletResponse would go here with empty implementations or mocks

        @Override public void flushBuffer() throws IOException { }
        @Override public int getBufferSize() { return 0; }
        @Override public String getCharacterEncoding() { return null; }
        @Override public String getContentType() { return null; }
        @Override public Locale getLocale() { return null; }
        @Override public ServletOutputStream getOutputStream() throws IOException { return null; }
        @Override public PrintWriter getWriter() throws IOException { return null; }
        @Override public boolean isCommitted() { return false; }
        @Override public void reset() { }
        @Override public void resetBuffer() { }
        @Override public void setBufferSize(int size) { }
        @Override public void setCharacterEncoding(String charset) { }
        @Override public void setContentLength(int len) { }
        @Override public void setContentLengthLong(long len) { }
        @Override public void setContentType(String type) { }
        @Override public void setLocale(Locale loc) { }
        @Override public void addCookie(Cookie cookie) { }
        @Override public boolean containsHeader(String name) { return false; }
        @Override public String encodeURL(String url) { return null; }
        @Override public String encodeRedirectURL(String url) { return null; }
        @Override public String encodeUrl(String url) { return null; }
        @Override public String encodeRedirectUrl(String url) { return null; }
        @Override public void sendError(int sc) throws IOException { }
        @Override public void sendRedirect(String location) throws IOException { }
        @Override public void setDateHeader(String name, long date) { }
        @Override public void addDateHeader(String name, long date) { }
        @Override public void setHeader(String name, String value) { }
        @Override public void setIntHeader(String name, int value) { }
        @Override public void addIntHeader(String name, int value) { }
        @Override public void setStatus(int sc) { }
        @Override public void setStatus(int sc, String sm) { }
        @Override public int getStatus() { return 0; }
        @Override public String getHeader(String name) { return null; }
        @Override public Collection<String> getHeaders(String name) { return null; }
        @Override public Collection<String> getHeaderNames() { return null; }
    }
}