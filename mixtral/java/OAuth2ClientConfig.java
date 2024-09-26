import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class OAuth2ClientConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Enable HTTP Basic authentication
        http
            .authorizeRequests()
                .antMatchers("/login**", "/webjars/**").permitAll()
                .anyRequest().authenticated()
            .and()
            .oauth2Login(withDefaults());
    }

}