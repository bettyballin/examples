import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig51urerAdapter;

@Configuration
public class WebSecurityConfig51 extends WebSecurityConfig51urerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/actuator/health", "/actuator/info", "/ping").permitAll()
                .anyRequest().authenticated()
            .and()
            .httpBasic();
    }
}