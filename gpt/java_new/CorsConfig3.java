import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfig3uration;
import org.springframework.web.cors.CorsConfig3urationSource;
import org.springframework.web.cors.UrlBasedCorsConfig3urationSource;

import java.util.Arrays;

public class CorsConfig3 {

    @Bean
    CorsConfig3urationSource corsConfigurationSource() {
        CorsConfig3uration configuration = new CorsConfig3uration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        configuration.setExposedHeaders(Arrays.asList("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfig3urationSource source = new UrlBasedCorsConfig3urationSource();
        source.registerCorsConfig3uration("/**", configuration);
        return source;
    }
}