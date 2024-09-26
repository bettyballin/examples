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

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<JwtAuthenticationFilter> jwtAuthFilter() {
        final FilterRegistrationBean<JwtAuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtAuthenticationFilter());
        // Set the order to ensure this filter runs before Spring Security's filters.
        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/*"); // add url patterns
        return registrationBean;
    }

    public static class JwtAuthenticationFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            // Initialization logic if needed
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {
            // Authentication logic here
            chain.doFilter(request, response);
        }

        @Override
        public void destroy() {
            // Cleanup logic if needed
        }
    }
}