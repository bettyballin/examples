import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
class TestConfig extends GlobalMethodSecurityConfiguration {
    private ApplicationContext applicationContext;

    @Autowired
    public TestConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler expressionHandler =
                new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(new PermissionEvaluatorProxyTest());
        expressionHandler.setApplicationContext(applicationContext);
        return expressionHandler;
    }
}

class PermissionEvaluatorProxyTest implements org.springframework.security.access.PermissionEvaluator {

    @Override
    public boolean hasPermission(org.springframework.security.core.Authentication authentication, Object targetDomainObject, Object permission) {
        // Implement your logic here
        return true;
    }

    @Override
    public boolean hasPermission(org.springframework.security.core.Authentication authentication, Serializable targetId, String targetType, Object permission) {
        // Implement your logic here
        return true;
    }
}