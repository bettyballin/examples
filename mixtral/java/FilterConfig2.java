import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import javax.servlet.DispatcherType;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

@SpringBootApplication
public class FilterConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(FilterConfigApplication.class, args);
    }
}

@Configuration
class FilterConfig {

    @Autowired
    private CustomFilter1 customFilter1;

    @Autowired
    private CustomFilter2 customFilter2;

    @Bean
    public FilterRegistrationBean<CustomFilter1> registerCustomFilter1() {
        FilterRegistrationBean<CustomFilter1> registration = new FilterRegistrationBean<>();

        registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));

        // Set the filter bean
        registration.setFilter(customFilter1);

        // Define URL pattern
        List<String> urlPatterns = Arrays.asList("/api/*");

        registration.addUrlPatterns(urlPatterns.toArray(new String[0]));

        // Set the order
        registration.setOrder(-25);

        return registration;
    }

    @Bean
    public FilterRegistrationBean<CustomFilter2> registerCustomFilter2() {

        FilterRegistrationBean<CustomFilter2> registration = new FilterRegistrationBean<>();

        // Set the filter bean
        registration.setFilter(customFilter2);

        // Define URL pattern
        List<String> urlPatterns = Arrays.asList("/api/*");

        registration.addUrlPatterns(urlPatterns.toArray(new String[0]));

        // Set the order
        registration.setOrder(-30);

        return registration;
    }
}

// Assuming the filter classes are defined as follows
import javax.servlet.*;
import java.io.IOException;

class CustomFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Filter logic
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}

class CustomFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Filter logic
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}