import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfig4uration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;

@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class MethodSecurityConfig4 extends GlobalMethodSecurityConfig4uration {

    @Autowired
    private AccessDecisionManager accessDecisionManager;

    @Autowired
    private MethodSecurityExpressionHandler methodSecurityExpressionHandler;

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return methodSecurityExpressionHandler;
    }

    @Override
    protected AccessDecisionManager accessDecisionManager() {
        return accessDecisionManager;
    }
}