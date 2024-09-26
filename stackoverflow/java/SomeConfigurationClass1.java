import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

// Assuming ClientResolveFilter is a valid Filter class
public class SomeConfigurationClass1 {

    @Bean
    public FilterRegistrationBean<ClientResolveFilter> clientResolveFilter() {
        final FilterRegistrationBean<ClientResolveFilter> frb = new FilterRegistrationBean<>();
        frb.setFilter(new ClientResolveFilter());
        frb.addUrlPatterns("/app/*");
        return frb;
    }

    // Rest of the code
}