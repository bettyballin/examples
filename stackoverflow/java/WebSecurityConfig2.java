import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig2urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig2 extends WebSecurityConfig2urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .mvcMatchers("/about").hasRole("USER")
            .anyRequest().authenticated();
    }
}