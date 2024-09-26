import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@SpringBootApplication
public class Temp1774 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1774.class, args);
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration samlCorConfig = new CorsConfiguration();
        samlCorConfig.addAllowedOrigin(CorsConfiguration.ALL);
        samlCorConfig.setAllowCredentials(true);
        samlCorConfig.addAllowedHeader("*");
        samlCorConfig.addExposedHeader("Location");
        samlCorConfig.addAllowedMethod("GET");

        source.registerCorsConfiguration("/saml/**", samlCorConfig);

        CorsConfiguration apiCorConfig = new CorsConfiguration();
        apiCorConfig.setAllowCredentials(true);
        apiCorConfig.addAllowedOrigin("https://example.com");
        apiCorConfig.addExposedHeader("Location");

        source.registerCorsConfiguration("/api/**", apiCorConfig);

        FilterRegistrationBean<CorsFilter> filter = new FilterRegistrationBean<>(new CorsFilter(source));

        return filter;
    }
}