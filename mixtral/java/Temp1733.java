import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1733 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Code to initialize Spring application context if needed
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                // Allow all users to visit the home page without any restrictions
                .antMatchers("/").permitAll()
                // Require authentication for accessing "/inquiry"
                .antMatchers("/inquiry").authenticated();
    }
}