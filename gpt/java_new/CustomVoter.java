import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import java.util.Collection;

public class CustomVoter {

    public int vote(Authentication authentication, Object o, Collection<ConfigAttribute> configAttributes) {
        if (o instanceof FilterInvocation) {
            FilterInvocation fi = (FilterInvocation) o;
            String url = fi.getRequest().getRequestURI();
            String httpMethod = fi.getRequest().getMethod();

            // Your logic to decide access based on the URL, HTTP method, and roles
            // Placeholder for the access decision logic
            boolean accessGranted = decideAccess(url, httpMethod, authentication.getAuthorities());

            return accessGranted ? ACCESS_GRANTED : ACCESS_DENIED;
        }

        // In case the object is not a FilterInvocation, abstain from voting
        return ACCESS_ABSTAIN;
    }

    private boolean decideAccess(String url, String httpMethod, Collection<?> roles) {
        // Implement your access decision logic here
        // This is a placeholder for actual logic and always grants access
        return true;
    }

    private static final int ACCESS_GRANTED = 1;
    private static final int ACCESS_DENIED = -1;
    private static final int ACCESS_ABSTAIN = 0;
}