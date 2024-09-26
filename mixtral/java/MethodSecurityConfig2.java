import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Override
    protected AccessDecisionManager accessDecisionManager() {
        List<AccessDecisionVoter<?>> voters = new ArrayList<>();

        MyAccessDecisionVoter myVoter = new MyAccessDecisionVoter();

        voters.add(myVoter);

        return new UnanimousBased(voters);
    }
}

class MyAccessDecisionVoter implements AccessDecisionVoter<Object> {

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public boolean supports(org.springframework.security.core.Authentication authentication) {
        return true;
    }

    @Override
    public int vote(org.springframework.security.core.Authentication authentication, Object object, java.util.Collection<org.springframework.security.access.ConfigAttribute> attributes) {
        // Custom voting logic here
        return ACCESS_GRANTED;
    }
}