import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.context.annotation.Bean;

public class Temp3002 {
    public static void main(String[] args) {
        Temp3002 temp = new Temp3002();
        CorsConfigurationSource source = temp.corsConfigurationSource();
        // You can add additional code here to test the CorsConfigurationSource if needed.
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.applyPermitDefaultValues();
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}