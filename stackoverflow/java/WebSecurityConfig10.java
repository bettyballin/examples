import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig10urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig10 extends WebSecurityConfig10urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .requiresChannel()
                .anyRequest()
                .requiresSecure()
            .and()
            .authorizeRequests()
                .antMatchers("/your_url").hasAuthority("your_role")
                .anyRequest().authenticated();
    }
}