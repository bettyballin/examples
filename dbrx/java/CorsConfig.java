import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsProcessor;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

import java.io.IOException;

@Configuration
public class CorsConfig {

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // Add your default CORS configuration here which will be used for all requests.
        CorsConfiguration apiCorsConfig = new CorsConfiguration();
        apiCorsConfig.addAllowedOrigin("https://example.com");
        apiCorsConfig.addAllowedHeader(CorsConfiguration.ALL);
        apiCorsConfig.addAllowedMethod(CorsConfiguration.ALL);
        source.registerCorsConfiguration("/api/**", apiCorsConfig);

        // Add your SAML CORS configuration here which will be used for all requests to /saml/**
        CorsConfiguration samlCorsConfig = new CorsConfiguration();
        samlCorsConfig.addAllowedOrigin(CorsConfiguration.ALL);
        samlCorsConfig.addAllowedHeader(CorsConfiguration.ALL);
        samlCorsConfig.addAllowedMethod(CorsConfiguration.ALL);

        // Implement your own logic for determining which CORS configuration to use based on the request URL.
        source.setCorsProcessor(new CorsProcessor() {
            @Override
            public boolean processRequest(ServerHttpRequest request, ServerHttpResponse response, CorsConfiguration config) throws IOException {

                if (request.getURI().getPath().startsWith("/saml/")) {
                    // Use SAML CORS configuration for requests to /saml/**
                    return super.processRequest(request, response, samlCorsConfig);
                } else {
                    // Otherwise use the default API CORS configuration
                    return super.processRequest(request, response, apiCorsConfig);
                }
            }
        });

        FilterRegistrationBean<CorsFilter> filterRegistrationBean = new FilterRegistrationBean<>(new CorsFilter(source));
        filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return filterRegistrationBean;
    }
}