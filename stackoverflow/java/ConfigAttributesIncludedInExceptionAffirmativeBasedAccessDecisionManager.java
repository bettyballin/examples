import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.access.vote.AbstractAccessDecisionManager;

import java.util.Collection;
import java.util.List;

public class ConfigAttributesIncludedInExceptionAffirmativeBasedAccessDecisionManager extends AbstractAccessDecisionManager {

    public ConfigAttributesIncludedInExceptionAffirmativeBasedAccessDecisionManager(List<AccessDecisionVoter<?>> decisionVoters) {
        super(decisionVoters);
    }

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException {
        // Implement the decision logic here
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        // Implement the supports logic here
        return false;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        // Implement the supports logic here
        return false;
    }
}