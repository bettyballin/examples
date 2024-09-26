import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.authorization.MethodInvocationResult;
import org.springframework.security.authorization.method.AuthorizationInterceptorsOrder;
import org.springframework.security.authorization.method.AuthorizationManagerAfterMethodInterceptor;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    Advisor myMethodSecurityAdvisor() {
        Pointcut pointcut = myCustomPointcut();
        AuthorizationManager<MethodInvocationResult> rules = myRules();
        AuthorizationManagerAfterMethodInterceptor interceptor =
                new AuthorizationManagerAfterMethodInterceptor(pointcut, rules);
        interceptor.setOrder(AuthorizationInterceptorsOrder.POST_AUTHORIZE.getOrder() + 1);
        return new DefaultPointcutAdvisor(pointcut, interceptor);
    }

    private Pointcut myCustomPointcut() {
        return new AnnotationMatchingPointcut(null, Secured.class);
    }

    private AuthorizationManager<MethodInvocationResult> myRules() {
        return (authentication, methodInvocationResult) -> {
            // Implement your custom authorization logic here
            return null;
        };
    }
}