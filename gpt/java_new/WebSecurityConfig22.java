import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig22urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig22 extends WebSecurityConfig22urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // ... other http configurations ...
            .authorizeRequests()
                .antMatchers("/path-to-websocket/**").permitAll()
                .anyRequest().authenticated();
            // ... other http configurations ...
    }

    // ... other configurations ...
}