import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfig4uration;
import org.springframework.web.cors.UrlBasedCorsConfig4urationSource;
import org.springframework.web.cors.CorsConfig4urationSource;

import java.util.Collections;

@Configuration
public class CorsConfig4 {

    @Bean
    public CorsConfig4urationSource corsConfigurationSource() {
        CorsConfig4uration configuration = new CorsConfig4uration();
        configuration.setAllowedOrigins(Collections.singletonList("*")); 
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfig4urationSource source = new UrlBasedCorsConfig4urationSource();
        source.registerCorsConfig4uration("/**", configuration);
        return source;
    }
}