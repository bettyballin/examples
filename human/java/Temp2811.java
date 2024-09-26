import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(
    securedEnabled = true,
    prePostEnabled = true,
    proxyTargetClass = true
)
public class GlobalSecurityConfiguration extends GlobalMethodSecurityConfiguration {
    @Override
    protected AccessDecisionManager accessDecisionManager() {
        AffirmativeBased accessDecisionManager = (AffirmativeBased) super.accessDecisionManager();
        accessDecisionManager.getDecisionVoters().replaceAll(voter -> {
            if (voter instanceof RoleVoter) {
                return new MyRoleVoter();
            } else {
                return voter;
            }
        });
        return accessDecisionManager;
    }
}

class MyRoleVoter extends RoleVoter {
    // Custom implementation of MyRoleVoter if needed
}