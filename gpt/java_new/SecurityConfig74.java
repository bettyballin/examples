import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig74urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig74 extends WebSecurityConfig74urerAdapter {

    private AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
        // Assuming this method returns a valid AuthenticationProvider
        return null; // Replace with actual provider instantiation
    }

    private AuthenticationProvider databaseAuthenticationProvider() {
        // Assuming this method returns a valid AuthenticationProvider
        return null; // Replace with actual provider instantiation
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        authManagerBuilder
                .authenticationProvider(activeDirectoryLdapAuthenticationProvider())
                .authenticationProvider(databaseAuthenticationProvider());
    }
}