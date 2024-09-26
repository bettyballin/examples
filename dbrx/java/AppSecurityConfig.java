import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public CustomAnonymousAuthProvider customAnonymousAuthenticationProvider()  {
        return new CustomAnonymousAuthProvider();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/resources/**").permitAll()
            .anyRequest().authenticated()
            .and().anonymous().authenticationProvider(customAnonymousAuthenticationProvider());
    }
}

class CustomAnonymousAuthProvider extends org.springframework.security.authentication.AnonymousAuthenticationProvider {
    public CustomAnonymousAuthProvider() {
        super("your_anonymous_key");  // Replace with your desired key
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Implement any custom logic here if needed
        return super.authenticate(authentication);
    }
}