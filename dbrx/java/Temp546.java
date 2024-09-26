import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp546 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requiresChannel()
            .antMatchers("/login").requiresSecure() // Require HTTPS for /login URL.
            .anyRequest().requiresInsecure();       // Allow other requests over insecure channel (HTTP).
    }

    public static void main(String[] args) {
        System.out.println("Security configuration set up.");
    }
}