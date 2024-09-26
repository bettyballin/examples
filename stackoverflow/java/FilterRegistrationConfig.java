import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FilterRegistrationConfig {

    private final XHeaderAuthenticationFilter xHeaderAuthenticationFilter;

    @Autowired
    public FilterRegistrationConfig(XHeaderAuthenticationFilter xHeaderAuthenticationFilter) {
        this.xHeaderAuthenticationFilter = xHeaderAuthenticationFilter;
    }

    @Bean
    public FilterRegistrationBean<XHeaderAuthenticationFilter> filterRegistrationBean() {
        FilterRegistrationBean<XHeaderAuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(xHeaderAuthenticationFilter);
        return registrationBean;
    }
}