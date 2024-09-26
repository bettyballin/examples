// Java classes usually do not parse XML Spring configuration files. However, if we assume that the provided XML is to be
// translated into Java-based Spring configuration, the following Java code snippet could be an example of how one could
// refactor the XML configuration into Java code using Spring's Java configuration.

package some.package;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Map;
import java.util.HashMap;

@Configuration
public class AppConfig3 {

    @Bean
    public MethodSecurityAccessDecisionManager methodSecurityAccessDecisionManager() {
        Map<String, AccessDecisionStrategy> strategies = new HashMap<>();
        strategies.put("GetByOwner", getByOwnerStrategy());
        strategies.put("SomeOther", someOtherStrategy());
        
        return new MethodSecurityAccessDecisionManager(strategies);
    }

    @Bean
    public GetByOwnerStrategy getByOwnerStrategy() {
        return new GetByOwnerStrategy();
    }

    @Bean
    public SomeOtherStrategy someOtherStrategy() {
        return new SomeOtherStrategy();
    }
}