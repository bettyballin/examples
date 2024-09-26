import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1047 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method for testing purposes
        System.out.println("Temp1047 class executed");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // Any other requests must be authorized
                .anyRequest().authenticated()
                // Allow unauthorized access to resources
                .antMatchers("/resources/**").permitAll();
    }
}