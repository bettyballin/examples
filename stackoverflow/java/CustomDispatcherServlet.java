import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.util.UrlPathHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomDispatcherServlet {

    private static final Logger pageNotFoundLogger = LoggerFactory.getLogger(CustomDispatcherServlet.class);
    private static final UrlPathHelper urlPathHelper = new UrlPathHelper();
    
    protected void noHandlerFound(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (pageNotFoundLogger.isWarnEnabled()) {
            String requestUri = urlPathHelper.getRequestUri(request);
            pageNotFoundLogger.warn("No mapping found for HTTP request with URI [" + requestUri + "] in DispatcherServlet with name '" + getServletName() + "'");
        }
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }

    // Dummy method to simulate getting the servlet name
    private String getServletName() {
        return "myServlet";
    }
}