import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomConfig {

    @Bean
    public DefaultMethodSecurityExpressionHandler defaultMethodSecurityExpressionHandler() {
        // Create your custom decorator
        MyCustomDecorator myCustomDecorator = new MyCustomDecorator();

        // Wrap the existing handler with your decorator
        return myCustomDecorator.wrap(new DefaultMethodSecurityExpressionHandler());
    }
}

// Assuming MyCustomDecorator class exists and has a wrap method
class MyCustomDecorator {
    public DefaultMethodSecurityExpressionHandler wrap(DefaultMethodSecurityExpressionHandler handler) {
        // Custom decoration logic
        return handler;
    }
}