import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp2620 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // This is the main method, but it won't start the Spring application.
        // Usually, you would have a Spring Boot application class with @SpringBootApplication to start the context.
        System.out.println("Application started.");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configure access control rules
        http.authorizeRequests()
            .antMatchers("/configuration/**").permitAll()
            .anyRequest().authenticated();

        // Custom authentication entry point can be set here, if needed
        // For example:
        // http.exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint());
    }
}