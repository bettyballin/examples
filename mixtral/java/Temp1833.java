import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.Arrays;
import java.util.List;

@Configuration
public class Temp1833 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Your main logic here
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors()
                .and().csrf().disable();

        // Other configurations...
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration configPublic = new CorsConfiguration().applyPermitDefaultValues();

        configPublic.setAllowedOrigins(Arrays.asList("http://myui.com", "https://myui.com"));

        // Set allowed headers explicitly instead of using "*" for better security
        List<String> allowHeaders = Arrays.asList("Authorization", "Cache-Control", "Content-Type");
        configPublic.setAllowedHeaders(allowHeaders);

        configPublic.setAllowedMethods(Arrays.asList("GET", "POST", "PUT"));

        source.registerCorsConfiguration("/api/**", configPublic);

        return source;
    }
}