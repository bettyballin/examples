import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextIntegrationFilter;

public class SecurityConfig {

    @Bean
    public FilterRegistrationBean<HttpSessionSecurityContextIntegrationFilter> httpSessionSecurityContextIntegrationFilter() {
        FilterRegistrationBean<HttpSessionSecurityContextIntegrationFilter> registration = new FilterRegistrationBean<>();

        HttpSessionSecurityContextIntegrationFilter integrationFilter = new HttpSessionSecurityContextIntegrationFilter();

        // Set the security context repository
        integrationFilter.setSpringSecurityContextRepository(httpSessionSecurityContextRepository());

        registration.setFilter(integrationFilter);

        return registration;
    }

    @Bean
    public HttpSessionSecurityContextRepository httpSessionSecurityContextRepository() {
        return new HttpSessionSecurityContextRepository();
    }

    // Add the rest of your filter chain definition here
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(httpSessionSecurityContextIntegrationFilter().getFilter(), SecurityContextPersistenceFilter.class);
        // Other configurations
    }
}