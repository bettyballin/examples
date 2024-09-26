import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;
import java.util.Collection;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        AffirmativeBased decisionManager = new AffirmativeBased(
            Arrays.asList(new CustomAccessDecisionVoter()));

        http.authorizeRequests()
                .accessDecisionManager(decisionManager)
                .anyRequest().authenticated()
                .and()
                .formLogin(); // Added form login for testing purposes
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build()
        );
    }

    private static class CustomAccessDecisionVoter implements AccessDecisionVoter<Object> {
        @Override
        public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) {
            // Custom voting logic here
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