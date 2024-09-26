import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class CustomMethodSecurityExpressionRoot extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

    public CustomMethodSecurityExpressionRoot(Authentication authentication) {
        super(authentication);
    }

    public boolean hasCustomRole(String role) {
        return getAuthentication().getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(auth -> auth.equalsIgnoreCase("ROLE_" + role));
    }

    @Override
    public void setFilterObject(Object filterObject) {
        // Implement if needed
    }

    @Override
    public Object getFilterObject() {
        // Implement if needed
        return null;
    }

    @Override
    public void setReturnObject(Object returnObject) {
        // Implement if needed
    }

    @Override
    public Object getReturnObject() {
        // Implement if needed
        return null;
    }

    @Override
    public Object getThis() {
        // Implement if needed
        return null;
    }
}