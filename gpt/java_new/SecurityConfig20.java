import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig20urerAdapter;

@EnableWebSecurity
public class SecurityConfig20 extends WebSecurityConfig20urerAdapter {

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