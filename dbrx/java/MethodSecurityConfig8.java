import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public MethodSecurityConfig methodSecurityConfig() {
        return new MethodSecurityConfig();
    }

    @Configuration
    public static class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

        @Override
        protected DefaultMethodSecurityExpressionHandler createExpressionHandler() {
            return new SecurityConfig.CustomMethodSecurityExpressionHandler();
        }
    }

    public static class CustomMethodSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {
        // Implement your custom SpEL evaluation logic here.
    }
}