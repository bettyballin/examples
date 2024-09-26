// The provided code snippet is a part of a Spring Security configuration method chain.
// It's incomplete and cannot be compiled as is. It should be included in a proper
// configuration class.

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig32urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig32 extends WebSecurityConfig32urerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .requestMatchers() //1
                .antMatchers("/login", "/oauth/authorize") //2
            .and() //3
            .authorizeRequests() //4
                .anyRequest() //5
                .authenticated(); //6
    }
}