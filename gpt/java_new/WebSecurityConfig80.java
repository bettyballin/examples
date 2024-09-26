import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig80urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig80 extends WebSecurityConfig80urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Your configuration goes here. For example:
        http
            .authorizeRequests()
                .anyRequest().authenticated()
            .and()
            .formLogin()
            .and()
            .httpBasic();
    }
}