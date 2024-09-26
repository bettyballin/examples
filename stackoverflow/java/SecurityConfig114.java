import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig114urerAdapter;

@EnableWebSecurity
public class SecurityConfig114 extends WebSecurityConfig114urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .defaultSuccessUrl("/homeLogged", true)
                .permitAll()
            .and()
            .authorizeRequests()
                .anyRequest().authenticated();
    }
}