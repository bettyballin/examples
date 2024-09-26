import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig80urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig80 extends WebSecurityConfig80urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .requiresChannel(channel ->
                channel
                    .antMatchers("/login").requiresSecure()
                    .anyRequest().requiresInsecure()
            );
    }
}