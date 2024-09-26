import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

import java.util.Collection;
import java.util.List;

public class ConfigAttributesIncludedInExceptionAffirmativeBasedAccessDecisionManager extends AffirmativeBased {

    public ConfigAttributesIncludedInExceptionAffirmativeBasedAccessDecisionManager(List<AccessDecisionVoter<?>> decisionVoters) {
        super(decisionVoters);
    }

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) {
        try {
            super.decide(authentication, object, configAttributes);
        } catch (Exception e) {
            throw new CustomAccessDeniedException("Access Denied", configAttributes, e);
        }
    }

    public static void main(String[] args) {
        // Example usage
        // This part would typically be managed by Spring Security configuration
    }
}

class CustomAccessDeniedException extends RuntimeException {
    private final Collection<ConfigAttribute> configAttributes;

    public CustomAccessDeniedException(String message, Collection<ConfigAttribute> configAttributes, Throwable cause) {
        super(message, cause);
        this.configAttributes = configAttributes;
    }

    public Collection<ConfigAttribute> getConfigAttributes() {
        return configAttributes;
    }
}