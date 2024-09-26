import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Temp1557 {

    @Autowired
    private PermissionEvaluator permissionEvaluator;

    @Bean
    public DefaultMethodSecurityExpressionHandler expressionHandler() {
        DefaultMethodSecurityExpressionHandler handler = new DefaultMethodSecurityExpressionHandler();
        handler.setPermissionEvaluator(permissionEvaluator);
        return handler;
    }

    public static void main(String[] args) {
        // Spring context would need to be started here to test the beans, 
        // but the main method is not typically where Spring beans are tested.
    }
}