import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfig5uration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig5 extends GlobalMethodSecurityConfig5uration {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        CustomMethodSecurityExpressionHandler expressionHandler = new CustomMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(new CustomPermissionEvaluator());
        expressionHandler.setApplicationContext(applicationContext);
        logger.debug("Method security expression handler configured to CustomMethodSecurityExpressionHandler");
        return expressionHandler;
    }

    // CustomMethodSecurityExpressionHandler and CustomPermissionEvaluator need to be defined elsewhere in the codebase
}