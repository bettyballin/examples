import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class CORSConfig {

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // Allow all origins methods and headers
        CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();

        // Add allowed origin
        List<String> allowOrigins = Arrays.asList("http://localhost:4200");

        if (allowOrigins != null && !allowOrigins.isEmpty()) {
            config.setAllowedOriginPatterns(allowOrigins.stream().collect(Collectors.toList()));

            // Add allowed methods
            List<HttpMethod> allowMethods = Arrays.asList(
                    HttpMethod.GET,
                    HttpMethod.POST,
                    HttpMethod.OPTIONS);

            config.setAllowedMethods(allowMethods.stream().map(HttpMethod::name).collect(Collectors.toList()));
        }

        source.registerCorsConfiguration("/**", config);

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));

        // Add filter before Spring Security
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return bean;
    }
}