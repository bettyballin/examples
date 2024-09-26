import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp939 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // This main method is not typically used in Spring Security configurations
        // Instead, we configure security in the configure method
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requiresChannel()
            .anyRequest().requiresSecure();
    }
}