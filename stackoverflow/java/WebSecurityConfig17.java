// The provided snippet seems to be XML configuration for Spring Security rather than Java code.
// Below is an example of how you might configure it in Java using HttpSecurity in a Spring Security configuration class.

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig17urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig17 extends WebSecurityConfig17urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            .and()
            // ... other configurations (like formLogin, logout etc.)
    }
}