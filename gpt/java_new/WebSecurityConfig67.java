import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig67urerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig67 extends WebSecurityConfig67urerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/", "/posthello").permitAll()
                .anyRequest().authenticated();
    }
}