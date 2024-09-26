import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig4urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig4 extends WebSecurityConfig4urerAdapter {
    // You can add override methods or additional configurations here
}