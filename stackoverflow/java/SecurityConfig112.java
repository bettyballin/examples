import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig112urerAdapter;
import org.springframework.security.authentication.AuthenticationProvider;

@EnableWebSecurity
public class SecurityConfig112 extends WebSecurityConfig112urerAdapter {

    private final AuthenticationProvider authenticationProvider;

    public SecurityConfig112(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authenticationProvider(authenticationProvider)
                .authorizeRequests()
                .antMatchers("/api/v1/specific").hasAuthority("ROLE_ONLY_FOR_THIS_ENDPOINT")
                .antMatchers("/api/v1/**").hasRole("ADMIN")
                .anyRequest().authenticated();
    }
}