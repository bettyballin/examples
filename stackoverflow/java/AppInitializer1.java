import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppInitializer1 {

    @Bean
    public FilterRegistrationBean<AccessTokenAlterFilter> sessionTimeoutFilter() {
        FilterRegistrationBean<AccessTokenAlterFilter> registrationBean = new FilterRegistrationBean<>();
        AccessTokenAlterFilter filter = new AccessTokenAlterFilter();

        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/oauth/token");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    // Assuming class AccessTokenAlterFilter exists and implements Filter
    // Otherwise, provide an implementation for it
    public class AccessTokenAlterFilter implements javax.servlet.Filter {
        @Override
        public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.FilterChain chain)
                throws java.io.IOException, javax.servlet.ServletException {
            // Filter implementation goes here
            chain.doFilter(request, response);
        }

        @Override
        public void init(javax.servlet.FilterConfig filterConfig) throws javax.servlet.ServletException {
            // Initialization code can go here
        }

        @Override
        public void destroy() {
            // Destruction code can go here
        }
    }
}