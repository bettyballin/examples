import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class Temp525 {

    public static void main(String[] args) {
        // Application entry point
    }

    @Bean
    @Qualifier("frontend")
    public AuthenticationManager front() {
        return new AuthenticationManager() {
            @Override
            public Authentication authenticate(Authentication authentication) {
                // Implement your authentication logic here
                return null;
            }
        };
    }
}