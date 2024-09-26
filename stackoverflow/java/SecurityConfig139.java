import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig139urerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
public class SecurityConfig139 extends WebSecurityConfig139urerAdapter {

    @Autowired
    private UserDetailsDao userDetailsDao;

    public AuthenticationSuccessHandler successHandler() {
        return new LoginAuthenticationSuccessHandler(userDetailsDao);
    }
    
    // Assume LoginAuthenticationSuccessHandler is implemented elsewhere
    // and UserDetailsDao is an interface with required methods.
}