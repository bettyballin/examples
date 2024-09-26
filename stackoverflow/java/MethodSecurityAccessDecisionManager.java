import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.InsufficientAuthenticationException;

import java.util.Collection;
import java.util.Map;

public class MethodSecurityAccessDecisionManager implements AccessDecisionManager {

    private Map<String, AccessDecisionVoter<MethodInvocation>> strategyMap;

    public MethodSecurityAccessDecisionManager(Map<String, AccessDecisionVoter<MethodInvocation>> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        ConfigAttribute configAttribute = getSingleConfigAttribute(configAttributes);
        AccessDecisionVoter<MethodInvocation> voter = strategyMap.get(configAttribute.getAttribute());
        if (voter == null) {
            throw new IllegalStateException("AccessDecisionVoter with name "
                    + configAttribute.getAttribute() + " was not found!");
        }
        int result = voter.vote(authentication, (MethodInvocation) object, configAttributes);
        if (result == AccessDecisionVoter.ACCESS_DENIED) {
            throw new AccessDeniedException("Access is denied");
        }
    }

    private ConfigAttribute getSingleConfigAttribute(Collection<ConfigAttribute> configAttributes) {
        if (configAttributes == null || configAttributes.size() != 1) {
            throw new IllegalArgumentException("Exactly one ConfigAttribute is required");
        }
        return configAttributes.iterator().next();
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return strategyMap.containsKey(attribute.getAttribute());
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return MethodInvocation.class.isAssignableFrom(clazz);
    }
}