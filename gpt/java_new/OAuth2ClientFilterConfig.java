import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

@Configuration
public class OAuth2ClientFilterConfig {

    @Bean
    public FilterRegistrationBean<DelegatingFilterProxy> oauth2ClientFilterRegistration() {
        FilterRegistrationBean<DelegatingFilterProxy> registration = new FilterRegistrationBean<>();
        DelegatingFilterProxy proxy = new DelegatingFilterProxy("oauth2ClientContextFilter");
        registration.setFilter(proxy);
        registration.setOrder(-100);
        return registration;
    }
}