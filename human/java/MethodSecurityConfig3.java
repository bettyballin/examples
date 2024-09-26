import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    @Override
    public AccessDecisionManager accessDecisionManager() {

        logger.debug("accessDecisionManager config...");

        Map<String, AccessDecisionStrategy> strategyMap = new HashMap<>();

        strategyMap.put("GetByOwner", new GetByOwnerStrategy());

        return new MethodSecurityAccessDecisionManager(strategyMap);
    }
}

// Dummy classes to make the code compile and run without errors
class MethodSecurityAccessDecisionManager implements AccessDecisionManager {
    private final Map<String, AccessDecisionStrategy> strategyMap;

    public MethodSecurityAccessDecisionManager(Map<String, AccessDecisionStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public void decide(org.springframework.security.core.Authentication authentication, Object object,
            java.util.Collection<org.springframework.security.access.ConfigAttribute> configAttributes) {
        // Implementation here
    }

    @Override
    public boolean supports(org.springframework.security.access.ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}

interface AccessDecisionStrategy {
    // Define methods here
}

class GetByOwnerStrategy implements AccessDecisionStrategy {
    // Implement methods here
}