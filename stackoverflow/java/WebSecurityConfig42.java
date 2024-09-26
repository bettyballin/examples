import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig42urerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig42 extends WebSecurityConfig42urerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
                .ignoringAntMatchers("/posthello")
                .and()
            .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/posthello").permitAll()
                .anyRequest().authenticated();
    }
}