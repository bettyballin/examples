import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;
import javax.servlet.ServletContext;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@Configuration
public class WebConfig {

    @Autowired
    private DelegatingFilterProxy springSecurityFilterChain;

    public static void onStartup(final ServletContext servletContext) throws Exception {
        var registration = new FilterRegistrationBean<>(springSecurityFilterChain);
        registration.setName("springSecurityFilterChain");
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        registration.setAsyncSupported(true);
        servletContext.addFilter("springSecurityFilterChain", springSecurityFilterChain).addMappingForUrlPatterns(null, false, "/*");
    }

    @Bean
    public FilterRegistrationBean<DelegatingFilterProxy> springSecurityFilterChain() {
        FilterRegistrationBean<DelegatingFilterProxy> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new DelegatingFilterProxy());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("springSecurityFilterChain");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}