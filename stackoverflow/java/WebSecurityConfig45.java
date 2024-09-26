import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig45urerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig45 extends WebSecurityConfig45urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .oauth2Login()
            .redirectionEndpoint()
            .baseUri("/welcome/login/oauth2/callback/*");
    }
}