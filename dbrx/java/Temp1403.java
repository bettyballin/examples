import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class Temp1403 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Entry point for the application
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
            .authorizeRequests()
                // Allow unauthenticated users to POST to /login.
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated();
                // Other configurations...
    }
}