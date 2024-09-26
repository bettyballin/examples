import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Component;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;

@Component
public class CustomMethodSecurityExpressionHandlerConfig implements BeanFactoryPostProcessor {

    @Autowired
    private MyCustomMethodSecurityExpressionHandler myCustomMethodSecurityExpressionHandler;

    @Override
    public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
        if (bean instanceof MethodSecurityExpressionHandler) {
            DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();

            // Register your custom method security handler
            expressionHandler.setPermissionEvaluator(myCustomMethodSecurityExpressionHandler);

            return expressionHandler;
        }

        return bean;
    }
}