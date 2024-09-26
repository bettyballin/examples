import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;

public class CustomerPortalSecurityExpressionRoot extends WebSecurityExpressionRoot {
    private static final Log logger = LogFactory.getLog(CustomerPortalSecurityExpressionRoot.class);

    private Authentication authentication;

    public CustomerPortalSecurityExpressionRoot(Authentication a, FilterInvocation fi) {
        super(a, fi);
        this.authentication = a;
    }

    @Override
    public void setPermissionEvaluator(PermissionEvaluator permissionEvaluator) {
        // Ignore permission evaluator and use the authentication object directly
    }

    public boolean hasPermission(String permission) {
        // Use the authenticated user's details to evaluate permission
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUserDetails) {
            return ((CustomUserDetails) principal).hasPermission(permission);
        }
        return false; // Changed to false because super.hasPermission(permission) is not applicable here
    }
}

interface CustomUserDetails {
    boolean hasPermission(String permission);
}