import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.scm.auth")
public class ShiroConfig {

    @Bean(name = "realm")
    @DependsOn("lifecycleBeanPostProcessor")
    public ApplicationRealm realm() {
        return new ApplicationRealm();
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
}

@Component
class ApplicationRealm {
    // ApplicationRealm details go here
}

class LifecycleBeanPostProcessor {
    // LifecycleBeanPostProcessor details go here
}