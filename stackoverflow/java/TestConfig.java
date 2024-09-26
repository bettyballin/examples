import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class TestConfig extends GlobalMethodSecurityConfiguration {
  private final ApplicationContext applicationContext;

  @Autowired
  public TestConfig(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  @Override
  protected MethodSecurityExpressionHandler createExpressionHandler() {
    DefaultMethodSecurityExpressionHandler expressionHandler =
      new DefaultMethodSecurityExpressionHandler();
    expressionHandler.setApplicationContext(applicationContext);
    return expressionHandler;
  }

  // Assume PermissionEvaluatorProxyTest is a valid implementation of PermissionEvaluator
  private static class PermissionEvaluatorProxyTest implements org.springframework.security.access.PermissionEvaluator {
    @Override
    public boolean hasPermission(org.springframework.security.core.Authentication authentication, Object targetDomainObject, Object permission) {
      // Implementation details
      return true;
    }

    @Override
    public boolean hasPermission(org.springframework.security.core.Authentication authentication, Serializable targetId, String targetType, Object permission) {
      // Implementation details
      return true;
    }
  }
}