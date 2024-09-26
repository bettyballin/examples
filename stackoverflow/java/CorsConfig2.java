import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfig2uration;
import org.springframework.web.cors.UrlBasedCorsConfig2urationSource;
import org.springframework.web.cors.CorsConfig2urationSource;

public class CorsConfig2 {

    @Bean
    public CorsConfig2urationSource corsConfigurationSource() {
        CorsConfig2uration configuration = new CorsConfig2uration().applyPermitDefaultValues();
        UrlBasedCorsConfig2urationSource source = new UrlBasedCorsConfig2urationSource();
        source.registerCorsConfig2uration("/**", configuration);
        return source;
    }
}