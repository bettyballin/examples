import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.WebInvocationPrivilegeEvaluator;

public class AccessChecker {
    @Autowired
    private WebInvocationPrivilegeEvaluator privilegeEvaluator;

    public boolean checkAccess() {
        Authentication auth = AuthUtils.getAuthentication();

        String contextPath = ""; // or your actual context path
        String urlToCheck = "/users"; // the URL you want to check for access
        String httpMethod = "GET"; // or the appropriate HTTP method for the request

        return privilegeEvaluator.isAllowed(contextPath, urlToCheck, httpMethod, auth);
    }
}