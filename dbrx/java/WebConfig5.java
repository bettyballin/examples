import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.filter.DelegatingFilterProxy;

@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean springSecurityFilterChain() {
        DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(delegatingFilterProxy);
        registrationBean.setOrder(1); 
        return registrationBean;
    }
}