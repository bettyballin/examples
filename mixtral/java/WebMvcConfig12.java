import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.ExpressionBasedPreInvocationAdvice;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebMvcConfig extends GlobalMethodSecurityConfiguration implements WebMvcConfigurer {

    @Autowired
    private HttpServletRequestFactory requestFactory;

    @Bean
    public DefaultMethodSecurityExpressionHandler methodSecurityExpressionHandler() {
        DefaultMethodSecurityExpressionHandler handler = new DefaultMethodSecurityExpressionHandler();
        SecurityExpressionMethods secExp = new SecurityExpressionMethods(requestFactory);
        ExpressionBasedPreInvocationAdvice advice = (ExpressionBasedPreInvocationAdvice) 
                org.springframework.util.ReflectionUtils.getField(
                    org.springframework.util.ReflectionUtils.findField(DefaultMethodSecurityExpressionHandler.class, "preInvocationAdvice"), handler);
        advice.setExpressionHandler(handler);
        return handler;
    }
}