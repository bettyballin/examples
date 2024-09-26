import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Temp3700 {
    public static void main(String[] args) {
        SpringApplication.run(Temp3700.class, args);
    }

    @Bean
    public FilterRegistrationBean<SetToken> setTokenRegistrationBean(SetToken filter) {
        var registration = new FilterRegistrationBean<>(filter);
        registration.setEnabled(false);
        return registration;
    }
}

class SetToken implements javax.servlet.Filter {
    @Override
    public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.FilterChain chain)
            throws java.io.IOException, javax.servlet.ServletException {
        // Filter logic here
    }
}