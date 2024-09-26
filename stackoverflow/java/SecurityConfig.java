// The given snippet is not valid Java code but a part of Spring Security XML configuration.
// It cannot be refactored into Java code directly without additional context.
// However, if the task is to configure the same rule using Java configuration, it might look like this:

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/**/WEB-INF/**").denyAll()
                .anyRequest().authenticated();
    }
}