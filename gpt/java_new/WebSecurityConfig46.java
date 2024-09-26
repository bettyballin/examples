import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig46urerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig46 extends WebSecurityConfig46urerAdapter {

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/error/**");
    }
    
    // Other beans and methods ...
}