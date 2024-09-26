import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig121urerAdapter;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig121 extends WebSecurityConfig121urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // other configuration ...
            .oauth2Login()
                .loginPage("/sso-login") // Custom login page if needed
                .authorizationEndpoint()
                    .authorizationRequestRepository(yourAuthorizationRequestRepository())
                    .and()
                .successHandler(yourAuthenticationSuccessHandler()); // Optional
    }
    
    public AuthorizationRequestRepository yourAuthorizationRequestRepository() {
        // return your AuthorizationRequestRepository implementation
        return null;
    }
    
    public AuthenticationSuccessHandler yourAuthenticationSuccessHandler() {
        // return your AuthenticationSuccessHandler implementation
        return null;
    }
}