import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public class CustomPreAuthenticatedProcessingFilter extends AbstractPreAuthenticatedProcessingFilter {
    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        // Extract the method name from the request.
        String methodName = extractMethodName(request);

        return new PreAuthenticatedAuthenticationToken(methodName, null); // Use null instead of empty string
    }

    private String extractMethodName(HttpServletRequest request) {
        // Implement your logic to find out which operation (method)
        // is being secured based on the current HTTP request.

        return "yourMethod";
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return null; // Add this method to satisfy AbstractPreAuthenticatedProcessingFilter
    }
}