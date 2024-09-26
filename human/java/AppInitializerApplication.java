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
public class AppInitializerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppInitializerApplication.class, args);
    }
}

@Configuration
class AppInitializer {
    @Bean
    public FilterRegistrationBean<AccessTokenAlterFilter> sessionTimeoutFilter() {
        FilterRegistrationBean<AccessTokenAlterFilter> registrationBean = new FilterRegistrationBean<>();
        AccessTokenAlterFilter filter = new AccessTokenAlterFilter();

        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/oauth/token");
        registrationBean.setOrder(1); // set precedence
        return registrationBean;
    }
}

class AccessTokenAlterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Filtering logic
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}