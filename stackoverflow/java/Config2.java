import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

public class Config2 {

    @Bean
    public FilterRegistrationBean<SetToken> setTokenRegistrationBean(SetToken filter) {
        FilterRegistrationBean<SetToken> registration = new FilterRegistrationBean<>(filter);
        registration.setEnabled(false);
        return registration;
    }
    
    // Assuming SetToken is a defined Filter class
    public class SetToken implements javax.servlet.Filter {
        // Implementation of the filter
    }
}