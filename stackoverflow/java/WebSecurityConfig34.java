import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig34urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig34 extends WebSecurityConfig34urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/login.jsp")
                .defaultSuccessUrl("/homeLogged", true)
                .permitAll()
            .and()
            // ... other configurations ...
            ;
    }
}