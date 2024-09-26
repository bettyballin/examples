import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfiguration15 {

    @Bean
    public SecurityConfig basicConfig(@Value("${authentication.type.oauth}") boolean isOauthEnabled) {
        if (isOauthEnabled) {
            return new ResourceServerSecurityConfig();
        } else {
            return new BasicSecurityConfig();
        }
    }
    
    // Assuming these classes exist
    public class SecurityConfig {}
    public class ResourceServerSecurityConfig extends SecurityConfig {}
    public class BasicSecurityConfig extends SecurityConfig {}
}