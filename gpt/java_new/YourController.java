import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

// Assume this is within a controller class
public class YourController {

    private RequestCache requestCache = new HttpSessionRequestCache();

    // Inside your controller method, you need to provide HttpServletRequest and HttpServletResponse
    public String yourMethod(HttpServletRequest request, HttpServletResponse response) {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            // Now you can check the targetUrl to determine which view to return.
            // For example:
            // return "redirect:" + targetUrl;
        }
        // Handle the case where there is no saved request
        // For example:
        // return "defaultView";
    }
}