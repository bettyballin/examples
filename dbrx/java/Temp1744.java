import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class Temp1744 {

    public static void main(String[] args) {
        // This is a Spring Security configuration class, it won't be executed with a main method
        // You need to run it in a Spring Boot application context
    }

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.oauth2ResourceServer(server -> server
            .jwt(jwt -> jwt
                .jwtAuthenticationConverter(new YourJwtAuthenticationConverter())
            )
        );

        return http.build();
    }

    // Dummy converter class to make the code compile
    static class YourJwtAuthenticationConverter extends JwtAuthenticationConverter {
        // Implement necessary methods here
    }
}