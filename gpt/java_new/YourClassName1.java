import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class YourClassName1 {
    private static final int MAX_CONTENT_LENGTH = 1024 * 1024; // Example max content length

    public void checkContentTypeAndLength(HttpServletRequest req) throws ServletException {
        if (!"application/json".equalsIgnoreCase(req.getContentType())) {
            throw new ServletException("Invalid content type");
        }
        if (req.getContentLength() > MAX_CONTENT_LENGTH) {
            throw new ServletException("Content too large");
        }
    }
}