import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig65urerAdapter;

@EnableWebSecurity
public class SecurityConfig65 extends WebSecurityConfig65urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .requestMatchers()
                .antMatchers("/api/user")
                .and()
            .authorizeRequests()
                .anyRequest().authenticated();
    }
}