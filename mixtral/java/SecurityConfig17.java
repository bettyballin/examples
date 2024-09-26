import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Add your custom security configuration here

        http.authorizeRequests().antMatchers("/static/**").permitAll()
            .anyRequest().authenticated();

        http.formLogin();

        super.configure(http);
    }

    public static void main(String[] args) {
        // You would typically run this within a Spring Boot application
        // The main method can be used to start the application
        org.springframework.boot.SpringApplication.run(SecurityConfig.class, args);
    }
}