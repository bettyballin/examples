import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import javax.servlet.http.HttpServletRequest;

public class UserRoleChecker {
    public boolean isUserInRole(HttpServletRequest request, String role) {
        SecurityContextHolderAwareRequestWrapper requestWrapper = 
          new SecurityContextHolderAwareRequestWrapper(request, "");
        return requestWrapper.isUserInRole(role);
    }
}