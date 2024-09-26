import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig50urerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig50 extends WebSecurityConfig50urerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // configure authentication manager
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // configure http security
    }
}