import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerPortalSecurityExpressionRoot extends WebSecurityExpressionRoot {

    private static final Logger logger = LoggerFactory.getLogger(CustomerPortalSecurityExpressionRoot.class);

    private UserDetails user;

    public CustomerPortalSecurityExpressionRoot(Authentication a, FilterInvocation fi) {
        super(a, fi);

        if (a != null && a.getPrincipal() instanceof UserDetails) {
            this.user = (UserDetails) a.getPrincipal();
        }
    }

    public boolean hasGotPermission(String title) {
        // Access user details here

        logger.debug("coming inside has Permission! @public class CustomerPortalSecurityExpressionRoot " + this.user);

        return true;
    }
}