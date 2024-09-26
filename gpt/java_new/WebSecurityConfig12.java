import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig12urerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
public class WebSecurityConfig12 extends WebSecurityConfig12urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // other configuration...
            .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
            // other configuration...
    }
}