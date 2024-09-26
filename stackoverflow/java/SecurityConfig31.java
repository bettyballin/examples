import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig31urerAdapter;

@EnableWebSecurity
public class SecurityConfig31 extends WebSecurityConfig31urerAdapter {

    public SecurityConfig31() {
        super(true);
    }
    // ...
}