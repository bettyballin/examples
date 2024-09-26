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
public class FilterConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilterConfigApplication.class, args);
    }
}

@Configuration
class FilterConfig {

    @Bean
    public FilterRegistrationBean<MyNonSecurityFilter> myNonSecurityFilter() {
        FilterRegistrationBean<MyNonSecurityFilter> registrationBean = new FilterRegistrationBean<>();
        MyNonSecurityFilter filter = new MyNonSecurityFilter();
        registrationBean.setFilter(filter);
        registrationBean.setOrder(1);
        return registrationBean;
    }
}

class MyNonSecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Filtering logic
        System.out.println("Executing MyNonSecurityFilter...");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup logic if needed
    }
}