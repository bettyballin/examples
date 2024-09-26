import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ...

        http
            .cors()
                .and()
                    .csrf()
                        .disable();

        // Rest of the configuration
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();

        // Allow credentials
        config.setAllowCredentials(true);

        // Add allowed origins
        List<String> allowOrigins = Arrays.asList("http://localhost:4200");

        if (allowOrigins != null && !allowOrigins.isEmpty()) {
            for (String origin : allowOrigins) {
                config.addAllowedOrigin(origin);
            }
            source.registerCorsConfiguration("/api/**", config);
        }

        return source;
    }
}