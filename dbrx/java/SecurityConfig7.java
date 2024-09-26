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

class PrincipalCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Principal check logic here
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}

@Configuration
class SecurityConfig {

    @Bean
    public FilterRegistrationBean<PrincipalCheckFilter> principalCheckFilter() {
        FilterRegistrationBean<PrincipalCheckFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new PrincipalCheckFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

}