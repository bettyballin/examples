import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig43urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig43 extends WebSecurityConfig43urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            // Public URLs
            .antMatchers("/", "/index", "/static/**", "/assets/**", "/register", "/password/reset", "/password/reset/complete", "/email/verify", "/view/**", "/embed/**").permitAll()
            // Candidate-specific page, assuming 'ID' is a path variable
            .antMatchers("/candidate/{ID}").access("hasRole('CANDIDATE') and @userSecurity.hasUserId(authentication, #ID)")
            .anyRequest().authenticated();
            
        // Other configurations ...
    }
    
    // Other methods and beans ...
}