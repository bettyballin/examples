import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfig2uration;
import org.springframework.web.cors.CorsConfig2urationSource;
import org.springframework.web.cors.UrlBasedCorsConfig2urationSource;

import java.util.Arrays;

public class CorsConfig2 {

    @Bean
    public CorsConfig2urationSource corsConfigurationSource() {
        CorsConfig2uration configuration = new CorsConfig2uration();
        configuration.setAllowedOrigins(Arrays.asList("https://yourdomain.com", "http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));

        UrlBasedCorsConfig2urationSource source = new UrlBasedCorsConfig2urationSource();
        source.registerCorsConfig2uration("/**", configuration);
        return source;
    }
}