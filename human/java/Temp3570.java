public class Temp3570 {
    public static void main(String[] args) {
        System.out.println("This is a placeholder for security configuration.");
        // Example usage of antMatchers in a configuration class
        // This is typically used within a Spring Security configuration class, not in main method
        // Here is an example of how it might look in a WebSecurityConfigurerAdapter implementation

    }
}

// Example of a Spring Security configuration class
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/api/v1/admin_role/*").hasAuthority("ROLE_ADMIN")
            .antMatchers("/api/v1/user_role/*").hasAuthority("ROLE_USER")
            .anyRequest().authenticated();
    }
}