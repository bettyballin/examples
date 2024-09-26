import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.PermissionEvaluator;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class TestConfig extends GlobalMethodSecurityConfiguration {

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();

        // Set your custom permission evaluator
        expressionHandler.setPermissionEvaluator(new PermissionEvaluatorProxyTest());

        return expressionHandler;
    }

    // Dummy implementation, replace with actual implementation
    public static class PermissionEvaluatorProxyTest implements PermissionEvaluator {
        @Override
        public boolean hasPermission(org.springframework.security.core.Authentication authentication, Object targetDomainObject, Object permission) {
            return true;
        }

        @Override
        public boolean hasPermission(org.springframework.security.core.Authentication authentication, Serializable targetId, String targetType, Object permission) {
            return true;
        }
    }

}