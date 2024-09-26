import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

@Configuration
public class WebSecurityConfig extends WebMvcAutoConfiguration {

    @Bean
    public FilterRegistrationBean<DelegatingFilterProxy> oauth2ClientFilterRegistration(DelegatingFilterProxy delegatingFilterProxy) {
        FilterRegistrationBean<DelegatingFilterProxy> registration = new FilterRegistrationBean<>();

        registration.setFilter(delegatingFilterProxy);

        return registration;
    }

    // ...

}