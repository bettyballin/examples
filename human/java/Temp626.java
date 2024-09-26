import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Temp626 {
    public static void main(String[] args) {
        // Dummy request and response objects for demonstration purposes
        HttpServletRequest request = null;
        HttpServletResponse response = null;

        RequestCache requestCache = new HttpSessionRequestCache();
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            System.out.println("Redirect URL: " + targetUrl);
        } else {
            System.out.println("No saved request found.");
        }
    }
}