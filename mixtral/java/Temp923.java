import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp923 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Spring Boot application would typically be started here
        System.out.println("Spring Security Configuration Example");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ...
            .authorizeRequests()
                .anyRequest().authenticated()
            .and()
            .csrf() // Enable CSRF protection with custom configuration
                .ignoringAntMatchers("/ignoreCSRF/**");
        // ...
    }
}