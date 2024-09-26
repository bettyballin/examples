import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig69urerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableWebSecurity
public class SecurityConfig69 extends WebSecurityConfig69urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // Assume other configurations are properly set
            .csrf().ignoringAntMatchers("/security/csrf");
    }
}

@RestController
class CsrfController {

    @GetMapping("/security/csrf")
    public String csrf() {
        return "CSRF token endpoint";
    }
}