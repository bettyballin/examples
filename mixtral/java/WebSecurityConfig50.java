import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public AuthenticationEntryPoint customAuthenticationEntryPoint() {
        return (request, response, authException) -> {
            if (authException instanceof DatabaseConnectionAuthenticationFailureException) {
                // Return status code 500
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } else {
                // Handle other exceptions
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
            }
        };
    }

    // Custom exception class
    public static class DatabaseConnectionAuthenticationFailureException extends RuntimeException {
        public DatabaseConnectionAuthenticationFailureException(String message) {
            super(message);
        }
    }

}