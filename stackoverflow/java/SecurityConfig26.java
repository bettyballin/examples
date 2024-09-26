import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig26urerAdapter;

@EnableWebSecurity
public class SecurityConfig26 extends WebSecurityConfig26urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/non-secure/**").permitAll()
                .antMatchers("/secure/**").hasAuthority("user")
                .and()
            .requiresChannel()
                .antMatchers("/non-secure/**").requiresInsecure()
                .and()
            .requiresChannel()
                .antMatchers("/secure/**").requiresSecure();
    }
}