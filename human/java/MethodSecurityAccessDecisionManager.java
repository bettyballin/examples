import java.util.Collection;
import java.util.Map;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.aopalliance.intercept.MethodInvocation;

public class MethodSecurityAccessDecisionManager implements AccessDecisionManager {

    private Map<String, AccessDecisionStrategy> strategyMap;

    public MethodSecurityAccessDecisionManager(Map<String, AccessDecisionStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        ConfigAttribute configAttribute = getSingleConfigAttribute(configAttributes);
        AccessDecisionStrategy accessDecisionStrategy = strategyMap.get(configAttribute.getAttribute());
        if (accessDecisionStrategy == null) {
            throw new IllegalStateException("AccessDecisionStrategy with name "
                    + configAttribute.getAttribute() + " was not found!");
        }
        try {
            accessDecisionStrategy.decide(authentication, (MethodInvocation) object, configAttribute);
        } catch (ClassCastException e) {
            throw new IllegalStateException();
        }
    }

    private ConfigAttribute getSingleConfigAttribute(Collection<ConfigAttribute> configAttributes) {
        if (configAttributes == null || configAttributes.size() != 1) {
            throw new IllegalStateException("Invalid config attribute configuration");
        }
        return configAttributes.iterator().next();
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(MethodInvocation.class);
    }

    public interface AccessDecisionStrategy {
        void decide(Authentication authentication, MethodInvocation methodInvocation, ConfigAttribute configAttribute) throws AccessDeniedException, InsufficientAuthenticationException;
    }
}