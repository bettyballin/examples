import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp583 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Entry point for the application
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Disable form login
        http.formLogin().disable();

        // Disable HTTP Basic authentication
        http.httpBasic().disable();

        // Configure CSRF protection
        http.csrf()
            .ignoringAntMatchers("/h2-console/**")
            .and();

        // Allow all requests
        http
          .authorizeRequests()
              .anyRequest().permitAll();
    }
}