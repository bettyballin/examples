import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig42urerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableWebSecurity
public class WebSecurityConfig42 extends WebSecurityConfig42urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... other configuration ...
            .sessionManagement()
                .invalidSessionUrl("/login?expired=true");
            // ... other session management configuration ...
            // ... other configuration ...
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        // ... method implementation ...
        return "login";
    }
}