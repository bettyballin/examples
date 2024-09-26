import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomMethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private AccessService accessService;

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();

        // Set the created method security expression root
        expressionHandler.setPermissionEvaluator(new PermissionEvaluator() {
            @Override
            public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
                return false;
            }

            @Override
            public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        expressionHandler.setDefaultRolePrefix("");

        return expressionHandler;
    }

}

public class CustomMethodSecurityExpressionRoot extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

    private AccessService accessService;

    public CustomMethodSecurityExpressionRoot(AccessService accessService) {
        super(null);
        this.accessService = accessService;
    }

    // Expose your service method to be used within Spring Security expressions
    public boolean hasPathPermission() {
         return accessService.hasAccess("requested_path");
     }

    @Override
    public void setFilterObject(Object filterObject) {
        // Implement if needed
    }

    @Override
    public Object getFilterObject() {
        return null;
    }

    @Override
    public void setReturnObject(Object returnObject) {
        // Implement if needed
    }

    @Override
    public Object getReturnObject() {
        return null;
    }

    @Override
    public Object getThis() {
        return null;
    }
}

interface AccessService {
    boolean hasAccess(String path);
}