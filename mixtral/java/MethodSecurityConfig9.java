import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
    // Your beans and other config here
}

// In a separate configuration file

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan
public class AspectConfig {

     @Bean
     public ActionRecord record() {
         return new ActionRecord();
     }
}

// Assuming ActionRecord is a class in your project
class ActionRecord {
    // Implementation of the ActionRecord class
}