import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfig1uration;
import org.springframework.web.cors.UrlBasedCorsConfig1urationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

public class CorsConfig1 {
    
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        UrlBasedCorsConfig1urationSource source = new UrlBasedCorsConfig1urationSource();

        // SAML-specific CORS configuration
        CorsConfig1uration samlCorsConfig1 = new CorsConfig1uration();
        samlCorsConfig1.addAllowedOrigin(CorsConfig1uration.ALL);
        samlCorsConfig1.addAllowedHeader(CorsConfig1uration.ALL);
        samlCorsConfig1.addAllowedMethod(CorsConfig1uration.ALL);
        samlCorsConfig1.setMaxAge(600L);
        source.registerCorsConfig1uration("/saml/**", samlCorsConfig1);

        // General API CORS configuration
        CorsConfig1uration apiCorsConfig1 = new CorsConfig1uration();
        apiCorsConfig1.addAllowedOrigin("https://example.com");
        apiCorsConfig1.addAllowedHeader(CorsConfig1uration.ALL);
        apiCorsConfig1.addAllowedMethod(CorsConfig1uration.ALL);
        source.registerCorsConfig1uration("/**", apiCorsConfig1);

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
}