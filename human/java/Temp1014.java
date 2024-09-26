import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UrlPathHelper;

public class Temp1014 {

    private static final Logger pageNotFoundLogger = LoggerFactory.getLogger(Temp1014.class);
    private static final UrlPathHelper urlPathHelper = new UrlPathHelper();

    public static void main(String[] args) {
        // Example usage
    }

    protected void noHandlerFound(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (pageNotFoundLogger.isWarnEnabled()) {
            String requestUri = urlPathHelper.getRequestUri(request);
            pageNotFoundLogger.warn("No mapping found for HTTP request with URI [" + requestUri + "] in DispatcherServlet with name '" + getServletName() + "'");
        }
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }

    private String getServletName() {
        // Return a mock servlet name for demonstration purposes
        return "Temp1014Servlet";
    }
}