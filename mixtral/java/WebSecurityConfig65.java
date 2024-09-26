import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        // Permit access to specific endpoints
        http
            .authorizeRequests()
                .antMatchers("/actuator/health", "/ping").permitAll()
                .anyRequest().authenticated()
            .and()
                .formLogin().permitAll();
    }
}