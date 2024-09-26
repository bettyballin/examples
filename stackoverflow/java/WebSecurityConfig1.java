import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig1urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig1 extends WebSecurityConfig1urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/**").hasRole("USER")
            .anyRequest().authenticated();
    }
}