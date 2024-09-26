// The provided snippet appears to be a part of an XML configuration file for security (possibly Spring Security) rather than a Java code snippet. 
// However, if you need to configure Spring Security in Java configuration, it would look something like this:

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/pages/*Role*").hasRole("INTERNO")
                .anyRequest().authenticated()
                .and()
            // ... other configurations
    }
}