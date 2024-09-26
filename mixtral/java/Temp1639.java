import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1639 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // The main method is not typically used in Spring Boot applications
        // but is included here to match the original request.
        System.out.println("Spring Security Configuration");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Allow access to static resources and login page without authentication
        http.authorizeRequests().antMatchers("/", "/login**").permitAll();

        // Secure other pages
        http.authorizeRequests()
            .anyRequest().authenticated();
    }
}