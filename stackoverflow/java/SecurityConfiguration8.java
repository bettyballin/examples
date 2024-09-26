// The provided snippet seems to be a part of a Spring Security configuration method.
// Standalone, it cannot be compiled as it lacks context and necessary imports.
// Below is an example of how it could be refactored within the context of a Spring Security configuration class.

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfiguration8 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/api/user/**", "/user").authenticated()
                .antMatchers("/api/admin/**", "/templates/admin/**", "/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll();
    }
}