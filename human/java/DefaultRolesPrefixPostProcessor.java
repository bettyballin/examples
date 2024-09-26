import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;

public class DefaultRolesPrefixPostProcessor implements BeanPostProcessor, PriorityOrdered {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SecurityContextHolderAwareRequestFilter) {
            SecurityContextHolderAwareRequestFilter filter = (SecurityContextHolderAwareRequestFilter) bean;
            filter.setRolePrefix("ROLE_");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public int getOrder() {
        return PriorityOrdered.LOWEST_PRECEDENCE;
    }

    public static void main(String[] args) {
        // Test the DefaultRolesPrefixPostProcessor here if needed
    }
}