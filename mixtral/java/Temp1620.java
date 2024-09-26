import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;

@SpringBootApplication
public class Temp1620 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1620.class, args);
    }

    @Bean
    public FilterRegistrationBean<OAuth2ClientContextFilter> oauth2ClientFilterRegistration(
            OAuth2ClientContextFilter filter) {
        FilterRegistrationBean<OAuth2ClientContextFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(filter);
        // Make sure this is higher than any security filters
        registration.setOrder(-100);

        return registration;
    }
}