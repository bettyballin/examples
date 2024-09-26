import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.FilterRegistrationBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CustomFilter customFilter() {
        return new CustomFilter();
    }
}

@Component
class CustomFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String path = request.getRequestURI();

        // Add your URLs here
        if (path.startsWith("/your-url")) {
            // Bypass JWT signature verification
            return;
        }

        // Continue with the filter chain
        filterChain.doFilter(request, response);
    }
}

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomFilter customFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Add your URLs here
        String[] urlPatterns = {"/your-url"};

        for (String pattern : urlPatterns) {
            FilterRegistrationBean<CustomFilter> registrationBean = new FilterRegistrationBean<>(customFilter);
            registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);

            // Add the filter before Spring Security's default filters
            http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(pattern).permitAll();
        }

        // Other security configurations
        http.authorizeRequests()
            .anyRequest().authenticated();
    }
}