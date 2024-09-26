import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;

@Configuration
public class SecurityConfig {

    @Bean
    public PreAuthenticatedAuthenticationProvider preauthAuthProvider() {
        return new PreAuthenticatedAuthenticationProvider();
    }
}