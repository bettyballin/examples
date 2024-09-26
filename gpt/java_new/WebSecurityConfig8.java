import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig8urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig8 extends WebSecurityConfig8urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // Allow unsecured access to the WSDL and web service endpoints
            .authorizeRequests()
                .antMatchers("/ws/**").permitAll()
            .and()
            // Ensure the rest of your application is secure
            .authorizeRequests()
                .anyRequest().authenticated();
    }
}