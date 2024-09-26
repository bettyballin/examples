import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig62urerAdapter;

public class SecurityConfig62 extends WebSecurityConfig62urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/swagger*/**").authenticated()
            .anyRequest().permitAll()
            .and()
            .csrf().disable();
    }
}