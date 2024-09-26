import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@Configuration
class FilterConfig {

    @Autowired
    private ReallyImportantFilter reallyImportantFilter;

    @Bean
    public FilterRegistrationBean<ReallyImportantFilter> filterRegistration() {
        final var registration = new FilterRegistrationBean<ReallyImportantFilter>();

        // Set the order of your custom filter
        registration.setOrder(Integer.MIN_VALUE);

        registration.addUrlPatterns("/*");

        registration.setFilter(reallyImportantFilter);

        return registration;
    }
}

class ReallyImportantFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Your filtering logic goes here
        System.out.println("Really important filter is processing the request");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}