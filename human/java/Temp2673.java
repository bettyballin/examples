import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@SpringBootApplication
public class Temp2673 {

    public static void main(String[] args) {
        SpringApplication.run(Temp2673.class, args);
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration samlCorsConfig = new CorsConfiguration();
        samlCorsConfig.addAllowedOrigin(CorsConfiguration.ALL);
        samlCorsConfig.addAllowedHeader(CorsConfiguration.ALL);
        samlCorsConfig.addAllowedMethod(CorsConfiguration.ALL);
        samlCorsConfig.setMaxAge(600L);
        source.registerCorsConfiguration("/saml/**", samlCorsConfig);

        CorsConfiguration apiCorsConfig = new CorsConfiguration();
        apiCorsConfig.addAllowedOrigin("https://example.com");
        apiCorsConfig.addAllowedHeader(CorsConfiguration.ALL);
        apiCorsConfig.addAllowedMethod(CorsConfiguration.ALL);
        apiCorsConfig.setMaxAge(600L);
        source.registerCorsConfiguration("/**", apiCorsConfig);

        FilterRegistrationBean<CorsFilter> filterRegistrationBean = new FilterRegistrationBean<>(new CorsFilter(source));
        filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return filterRegistrationBean;
    }
}