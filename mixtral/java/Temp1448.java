import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1448 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // This main method is redundant for a Spring Security configuration class
        // Spring Boot application would typically use a Spring Boot Application class to launch
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin().loginPage("/login");

        // Disable CSRF protection
        http.csrf().disable();

        // Allow access to the specified URLs for users with either "RM" or "RF" roles
        http
            .authorizeRequests()
                .antMatchers("/index", "/ajouterFilier").hasAnyRole("RM", "RF");

        // Handle exceptions and redirect unauthorized requests
        http.exceptionHandling().accessDeniedPage("/403");
    }
}