import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1161 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method content, if needed
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()

            // Enable basic authentication for /user/login
            .antMatcher("/user/login").httpBasic()

            // Disable security for other endpoints
            .and().authorizeRequests().anyRequest().permitAll();
    }
}