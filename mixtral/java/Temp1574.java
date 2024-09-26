import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // Allow all origins
        CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();

        // Add allowed origin
        List<String> allowOrigins = Arrays.asList("http://localhost:4200", "https://your-domain");

        if (allowOrigins != null) {
            config.setAllowedOriginPatterns(allowOrigins);

            // Add allowed methods
            List<HttpMethod> allowMethods = Arrays.asList(
                    HttpMethod.GET,
                    HttpMethod.POST
            );

            if (allowMethods != null) {
                config.setAllowedMethods(allowMethods.stream().map(HttpMethod::name).collect(Collectors.toList()));

                // Add allowed headers
                List<String> allowHeaders = Arrays.asList("Authorization", "Cache-Control");

                if (!CollectionUtils.isEmpty(allowHeaders)) {
                    config.setAllowedHeaders(allowHeaders);
                }
            }
        }

        source.registerCorsConfiguration("/api/**", config);

        return source;
    }
}