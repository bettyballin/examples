import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

public class Temp2216 {
    public static void main(String[] args) {
        // Spring application context needs to be initialized here to use @Bean
    }

    @Bean
    public FilterRegistrationBean<CommonsRequestLoggingFilter> filterRegistrationBean() {
        final FilterRegistrationBean<CommonsRequestLoggingFilter> registrationBean = new FilterRegistrationBean<>();

        CommonsRequestLoggingFilter loggingFilter = commonRequestLoggingFilter();

        registrationBean.setFilter(loggingFilter);

        // Use this for matching any request that has "/api/" anywhere in the URL path after context root
        registrationBean.addUrlPatterns("/**/api/*");

        return registrationBean;
    }
    
    @Bean
    public CommonsRequestLoggingFilter commonRequestLoggingFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeClientInfo(true);
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        return filter;
    }
}