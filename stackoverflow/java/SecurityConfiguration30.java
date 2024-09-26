import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.authentication.AuthenticationProvider;

public class SecurityConfiguration30 {

    private AuthenticationProvider authProvider;

    // Assume that authProvider is already instantiated (e.g., via constructor or @Autowired)

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }
}