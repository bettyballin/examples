import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfig8uration;
import org.springframework.security.access.vote.ConsensusBased;
import java.util.List;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class MethodSecurityConfig8 extends GlobalMethodSecurityConfig8uration {

    @Override
    protected AccessDecisionManager accessDecisionManager() {
        return new ConsensusBased(List.of());
    }
}