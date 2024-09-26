import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp501 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // Allow anonymous access (no authentication required)
                .antMatchers("/app/rest/**").permitAll();
        // Add other configurations as needed
    }

    public static void main(String[] args) {
        // Spring Boot application would typically be started here
    }
}