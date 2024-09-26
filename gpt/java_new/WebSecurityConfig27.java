import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig27urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig27 extends WebSecurityConfig27urerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configure your security rules here
    }
}