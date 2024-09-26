import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class WebSecurityApp {
    public static void main(String[] args) {
        SpringApplication.run(WebSecurityApp.class, args);
    }
}

@Configuration
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // Your other configurations

    @Bean
    public FilterRegistrationBean springSecurityFilterChain() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy("springSecurityFilterChain");
        registration.setFilter(delegatingFilterProxy);
        registration.addUrlPatterns("/*"); // Add URL patterns
        registration.setName("springSecurityFilterChain"); // Set a name
        registration.setOrder(1); // Set the order
        return registration;
    }
}