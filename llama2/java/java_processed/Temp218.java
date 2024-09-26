import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp218 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Spring Boot applications are typically started with a main method. 
        // However, the security configuration should be handled by Spring Security, not in the main method.
        System.out.println("Application started");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").permitAll();
    }
}