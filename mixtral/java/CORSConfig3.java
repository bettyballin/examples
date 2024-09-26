import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.List;

@Configuration
@EnableWebSecurity
public class CORSConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        final var source = new UrlBasedCorsConfigurationSource();

        // Add a configuration for the endpoint at /dothings
        final var config = new CorsConfiguration().applyPermitDefaultValues();

        // Allow requests from "http://localhost:2222"
        config.setAllowedOrigins(List.of("http://localhost:2222"));

        source.registerCorsConfiguration("/dothings", config);
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults());
    }
}