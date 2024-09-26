import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.access.PermissionEvaluator;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private PermissionEvaluator permissionEvaluator;

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler expressionHandler =
                new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(permissionEvaluator);
        return expressionHandler;
    }

    @Bean
    public PermissionEvaluator permissionEvaluator() {
        return new CustomPermissionEvaluator();
    }
}

class CustomPermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(org.springframework.security.core.Authentication authentication,
                                 java.lang.Object targetDomainObject,
                                 java.lang.Object permission) {
        // Implement your custom permission logic here
        return true;
    }

    @Override
    public boolean hasPermission(org.springframework.security.core.Authentication authentication,
                                 java.io.Serializable targetId,
                                 java.lang.String targetType,
                                 java.lang.Object permission) {
        // Implement your custom permission logic here
        return true;
    }
}