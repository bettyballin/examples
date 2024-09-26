import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;

import java.util.Collection;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ... other security configurations ...

        http.authorizeRequests()
            .accessDecisionManager(new CustomAccessDecisionManager())
            .anyRequest().authenticated();
    }

    public class CustomAccessDecisionManager extends UnanimousBased {

        public CustomAccessDecisionManager() {
            super(List.of(new CustomAccessDecisionVoter()));
        }
    }

    public class CustomAccessDecisionVoter implements AccessDecisionVoter {

        @Override
        public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
            // Custom access decision logic
            return ACCESS_GRANTED;
        }

        @Override
        public boolean supports(ConfigAttribute attribute) {
            return true;
        }

        @Override
        public boolean supports(Class<?> clazz) {
            return true;
        }
    }
}