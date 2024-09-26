import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig22urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig22 extends WebSecurityConfig22urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/admin").hasAnyRole("USER")
                .and()
            // ... other configurations
    }
}