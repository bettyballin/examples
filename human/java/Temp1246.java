import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1246 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // This main method is typically not used for Spring Security configuration.
        // Spring Boot applications would use SpringApplication.run(Temp1246.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable();
    }
}