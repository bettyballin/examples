import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.FilterChainProxy;

import javax.servlet.ServletContext;

@Configuration
public class WebConfig {

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    @Bean
    public FilterRegistrationBean<FilterChainProxy> securityFilterChain(
            final ServletContext servletContext) {
        var registration = new FilterRegistrationBean<>(springSecurityFilterChain);
        registration.setOrder(-105);
        return registration;
    }
}