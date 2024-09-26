import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.aopalliance.intercept.MethodInvocation;

public class CustomMethodSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {

    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(
            Authentication authentication, MethodInvocation invocation) {
        // This will allow us to use 'principal' in our SpEL expressions

        final CustomMethodSecurityExpressionRoot root =
                new CustomMethodSecurityExpressionRoot(authentication);

        return root;
    }
}

class CustomMethodSecurityExpressionRoot implements MethodSecurityExpressionOperations {

    private final Authentication authentication;

    public CustomMethodSecurityExpressionRoot(Authentication authentication) {
        this.authentication = authentication;
    }

    // Implement required methods from MethodSecurityExpressionOperations interface
    @Override
    public void setFilterObject(Object filterObject) {
        // Implementation here
    }

    @Override
    public Object getFilterObject() {
        return null;
    }

    @Override
    public void setReturnObject(Object returnObject) {
        // Implementation here
    }

    @Override
    public Object getReturnObject() {
        return null;
    }

    @Override
    public Object getThis() {
        return null;
    }

    // Other custom methods can be implemented here
}