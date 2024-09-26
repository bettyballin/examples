import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp649 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // The main method can be used to run a Spring Boot application.
        // To make this class executable, you will need to set up a Spring Boot application.
        // SpringApplication.run(Temp649.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/login").permitAll() // Allow anonymous /login requests.
            .anyRequest().authenticated();
    }
}