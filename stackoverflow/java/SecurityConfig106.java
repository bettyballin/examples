// To provide a meaningful refactored code snippet, I'm assuming this line is part of a Spring Security configuration method.
// The following refactored code should be part of a configuration class extending WebSecurityConfig106urerAdapter or implementing WebSecurityConfig106urer.
// It contains a method configuring HttpSecurity object.

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig106urerAdapter;

@EnableWebSecurity
public class SecurityConfig106 extends WebSecurityConfig106urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/welcome", "/inventory/**", "/sales/**")
                .access("hasRole('USER')")
                // ... further configuration
            ;
    }
}