import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.access.vote.AuthenticatedVoter;

import java.util.Arrays;

@EnableWebSecurity
public class Temp1300 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method does not need to do anything for a Spring Security configuration class
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // permit all access to login page
                .antMatchers("/authentication/login**").permitAll()
                // any other request needs authentication
                .anyRequest().authenticated()
                // use your custom AccessDecisionManager
                .accessDecisionManager(accessDecisionManager());
    }

    private AccessDecisionManager accessDecisionManager() {
        return new AffirmativeBased(Arrays.asList(new RoleVoter(), new AuthenticatedVoter()));
    }
}