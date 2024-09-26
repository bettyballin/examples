import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig39urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig39 extends WebSecurityConfig39urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Define your configuration here
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .and()
            .httpBasic();
    }
}