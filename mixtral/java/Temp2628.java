import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@Configuration
public class Temp2628 {
    public static void main(String[] args) {
        // Your main method implementation
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        // Your custom converter implementation
        return new JwtAuthenticationConverter();
    }
}