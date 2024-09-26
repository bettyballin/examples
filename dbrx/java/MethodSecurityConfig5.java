import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = false)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Override
    protected void init() {
        // Add this method to avoid compilation error
    }
}