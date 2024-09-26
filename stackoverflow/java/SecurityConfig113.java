import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.authentication.AuthenticationProvider;

public class SecurityConfig113 {

    private AuthenticationProvider authenticationProvider;
    private HttpSecurity httpSecurity;

    public SecurityConfig113(AuthenticationProvider authenticationProvider, HttpSecurity httpSecurity) {
        this.authenticationProvider = authenticationProvider;
        this.httpSecurity = httpSecurity;
    }

    public void configureHttpSecurity() throws Exception {
        httpSecurity
                .authenticationProvider(authenticationProvider)
                .authorizeRequests()
                .antMatchers("/api/v1/specific").hasAuthority("ROLE_ONLY_FOR_THIS_ENDPOINT")
                .antMatchers("/api/v1/**").hasRole("ADMIN")
                .and()
                .csrf().disable();
    }
}