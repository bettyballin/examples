import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig127urerAdapter;

public class SecurityConfig127 extends WebSecurityConfig127urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/swagger*/**").authenticated()
                .anyRequest().permitAll()
            .and()
            .httpBasic();
    }
}