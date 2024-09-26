// Assuming this snippet is part of a method within a Spring Security configuration
// It should be wrapped in a method inside a configuration class that extends WebSecurityConfig118urerAdapter

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig118urerAdapter;

@EnableWebSecurity
public class SecurityConfig118 extends WebSecurityConfig118urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... other configurations
            .authorizeRequests()
                .antMatchers("/foos/**").hasIpAddress("xx.xxx.xxx.xx")
            // ... further configurations
            ;
    }
}