import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@SpringBootApplication
public class FilterRegistrationApp {

    public static void main(String[] args) {
        SpringApplication.run(FilterRegistrationApp.class, args);
    }

    @Bean
    public FilterRegistrationBean<CommonsRequestLoggingFilter> loggingFilter() {
        FilterRegistrationBean<CommonsRequestLoggingFilter> registrationBean = new FilterRegistrationBean<>();
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setMaxPayloadLength(10000);
        registrationBean.setFilter(loggingFilter);
        registrationBean.addUrlPatterns("/api/*");
        return registrationBean;
    }
}