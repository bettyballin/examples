// The provided code snippet seems to be part of a Spring Security configuration method chain.
// As it is not a complete method or class, it cannot be compiled successfully as standalone Java code.
// A refactored version of this snippet would need to be placed within a proper configuration method.
// Here's an example of how it could be used within a configure method of a WebSecurityConfig138urerAdapter:

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig138urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig138 extends WebSecurityConfig138urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... other configurations ...
            .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/ws/**").authenticated()
            // ... other configurations ...
            ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // configure your authentication manager here
    }
}