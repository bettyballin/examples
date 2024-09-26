import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.intercept.aopalliance.AuthorizationManagerAfterMethodInterceptor;
import org.springframework.security.access.method.AuthorizationManager;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.access.method.MethodSecurityMetadataSourceAdvisor;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.aop.Pointcut;
import org.springframework.security.access.intercept.AuthorizationInterceptorsOrder;
import org.springframework.security.core.Authentication;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration54 {

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public MethodSecurityMetadataSourceAdvisor myMethodSecurityAdvisor(MethodSecurityMetadataSource metadataSource, AuthorizationManager<Authentication> authorizationManager) {
        MethodSecurityMetadataSourceAdvisor advisor = new MethodSecurityMetadataSourceAdvisor("myAdviceBean", metadataSource, authorizationManager);
        advisor.setOrder(AuthorizationInterceptorsOrder.POST_AUTHORIZE.getOrder() + 1);
        return advisor;
    }
}