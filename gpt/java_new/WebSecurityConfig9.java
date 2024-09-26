import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig9urerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig9 extends WebSecurityConfig9urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Your custom configuration here. For example:
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .and()
            .httpBasic();
    }
}