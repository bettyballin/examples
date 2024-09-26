import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig25urerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig25 extends WebSecurityConfig25urerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Configure authentication manager
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configure http security
    }
}