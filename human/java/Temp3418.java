import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@SpringBootApplication
public class Temp3418 {

    public static void main(String[] args) {
        SpringApplication.run(Temp3418.class, args);
    }

    @Bean
    public FilterRegistrationBean<ClientResolveFilter> clientResolveFilter() {
        final FilterRegistrationBean<ClientResolveFilter> frb = new FilterRegistrationBean<>();
        frb.setFilter(new ClientResolveFilter());
        frb.addUrlPatterns("/app/*");
        return frb;
    }

    public static class ClientResolveFilter implements Filter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            // Initialization logic if needed
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {
            // Filter logic
            chain.doFilter(request, response);
        }

        @Override
        public void destroy() {
            // Cleanup logic if needed
        }
    }
}