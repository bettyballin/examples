import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.expression.WebExpressionVoter;

import java.util.Arrays;

public class Temp1414 extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAccessVoter customAccessVoter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        AccessDecisionManager accessDecisionManager = new AffirmativeBased(Arrays.asList(
                new RoleVoter(),
                new WebExpressionVoter(),
                customAccessVoter
        ));

        // Configure HttpSecurity with accessDecisionManager
        http
            .authorizeRequests()
            .accessDecisionManager(accessDecisionManager)
            // Add other configurations as needed
            .anyRequest().authenticated();
    }

    // CustomAccessVoter implementation or bean definition must be provided
}