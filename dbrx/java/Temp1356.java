import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
            // other configurations...
            .authorizeRequests()
            .anyRequest().authenticated();
    }

    public static void main(String[] args) {
        // The main method can be used to launch the application if needed.
        // However, in a Spring Boot application, you would typically have a SpringApplication.run() call here.
    }
}