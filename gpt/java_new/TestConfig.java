import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class TestConfig extends GlobalMethodSecurityConfiguration {

  @Autowired
  private ApplicationContext applicationContext;

  @Override
  protected MethodSecurityExpressionHandler createExpressionHandler() {
    DefaultMethodSecurityExpressionHandler expressionHandler =
      new DefaultMethodSecurityExpressionHandler();
    expressionHandler.setPermissionEvaluator(permission());
    expressionHandler.setApplicationContext(applicationContext);
    return expressionHandler;
  }

  @Bean
  public EventTypePermission permission() {
    return new EventTypePermission();
  }
}

class EventTypePermission {
  // Implementation of the permission logic
}

class PermissionEvaluatorProxyTest {
  // Implementation of the permission evaluator proxy logic
}