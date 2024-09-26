import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2890 {
    public static void main(String[] args) {
        // This is just a placeholder to execute the Spring Security configuration
        System.out.println("Spring Security Configuration Initialized.");
    }
}

@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("sahil")
            .password("{noop}123") // {noop} is for plain text password, not recommended for production
            .roles("ADMIN", "USER");
    }
}