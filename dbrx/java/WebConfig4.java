import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Configuration
    static class WebConfig {

        @Bean
        public FilterRegistrationBean<DelegatingFilterProxy> delegatingFilterProxy() {
            FilterRegistrationBean<DelegatingFilterProxy> registration = new FilterRegistrationBean<>();
            registration.setFilter(new DelegatingFilterProxy("oauth2ClientContextFilter"));
            registration.addUrlPatterns("/*");
            return registration;
        }
    }
}