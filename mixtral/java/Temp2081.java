import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;

@SpringBootApplication
public class Temp2081 {
    public static void main(String[] args) {
        SpringApplication.run(Temp2081.class, args);
    }

    @Bean
    public FilterRegistrationBean<CustomPKCERequestFilter> pkceRequestFilter() {
        CustomPKCERequestFilter requestFilter = new CustomPKCERequestFilter();

        FilterRegistrationBean<CustomPKCERequestFilter> registration
                = new FilterRegistrationBean<>(requestFilter);

        // Set priority to execute before Spring Security's OAuth2AuthorizationRequestRedirectFilter
        registration.setOrder(OAuth2AuthorizationRequestRedirectFilter.DEFAULT_ORDER - 10);

        return registration;
    }
}

class CustomPKCERequestFilter implements javax.servlet.Filter {
    @Override
    public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.FilterChain chain) 
            throws java.io.IOException, javax.servlet.ServletException {
        // Custom filter logic
        chain.doFilter(request, response);
    }
}