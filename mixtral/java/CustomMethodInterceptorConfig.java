import org.springframework.aop.Pointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.ExpressionBasedPreInvocationAdvice;
import org.springframework.security.access.prepost.PreInvocationAuthorizationAdviceVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import java.util.Arrays;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomMethodInterceptorConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private PrivilegeManager privilegeManager;

    @Autowired
    private MyService myService;

    @Bean
    public DefaultPointcutAdvisor customDefaultPointcutAdvisor() {
        ExpressionBasedPreInvocationAdvice advice = new ExpressionBasedPreInvocationAdvice();
        
        String expressionString = "hasAnyRole(@privilegeManager.privilegedRoles) or (@myService.verify(#id, this.getType()))";
        
        advice.setExpressionHandler(getExpressionHandler());
        
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        
        Pointcut pointcut = new AnnotationMatchingPointcut(null, PreAuthorize.class);
        
        advisor.setPointcut(pointcut);
        advisor.setAdvice(advice);
        
        return advisor;
    }

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return new DefaultMethodSecurityExpressionHandler();
    }
    
    @Bean
    public AffirmativeBased accessDecisionManager() {
        return new AffirmativeBased(Arrays.asList(
            new PreInvocationAuthorizationAdviceVoter(new ExpressionBasedPreInvocationAdvice()),
            new RoleVoter()
        ));
    }
}