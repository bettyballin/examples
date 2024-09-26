// This snippet appears to be a configuration from a Spring Security XML configuration file.
// It cannot be directly refactored into Java code without additional context.
// However, if you were to configure this in a Java config, it might look something like this:

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig75urerAdapter;

public class SecurityConfig75 extends WebSecurityConfig75urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/rest/Admin")
            .access("hasAuthority('Admin') and hasAuthority('Employee')");
        // ... other configurations ...
    }
}