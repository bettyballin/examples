import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfig1uration;
import org.springframework.web.cors.UrlBasedCorsConfig1urationSource;
import org.springframework.web.cors.CorsConfig1urationSource;

public class CorsConfig1 {

    @Bean
    public CorsConfig1urationSource corsConfigurationSource() {
        final CorsConfig1uration configuration = new CorsConfig1uration();
        configuration.applyPermitDefaultValues();
        final UrlBasedCorsConfig1urationSource source = new UrlBasedCorsConfig1urationSource();
        source.registerCorsConfig1uration("/**", configuration);
        return source;
    }
}