import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig95urerAdapter;
import org.springframework.security.authentication.AuthenticationProvider;

public class SecurityConfig95 extends WebSecurityConfig95urerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("my-path/**").hasAuthority("RELEVANT_AUTHORITY")
                .and()
            .httpBasic()
                .and()
            .authenticationProvider(new ClusterInternalAuthenticationProvider());
    }

    class ClusterInternalAuthenticationProvider implements AuthenticationProvider {
        // Implementation of the AuthenticationProvider interface
    }
}