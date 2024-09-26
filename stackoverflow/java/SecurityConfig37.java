// This code snippet appears to be a part of a security configuration method using Spring Security.
// It cannot be compiled on its own as it is not a complete class or method.
// However, I can provide a context where it might be used, such as within a configure(HttpSecurity http) method inside a WebSecurityConfig37urerAdapter class.

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig37urerAdapter;

@EnableWebSecurity
public class SecurityConfig37 extends WebSecurityConfig37urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/public/**", "/resources/**", "/resources/public/**").permitAll()
            // Other configurations can follow...
            ;
    }
}