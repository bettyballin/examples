import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@SpringBootApplication
public class Temp312 {
    public static void main(String[] args) {
        SpringApplication.run(Temp312.class, args);
    }

    @Bean
    public FilterRegistrationBean<DelegatingFilterProxy> springSecurityFilterChain() {
        DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
        delegatingFilterProxy.setTargetBeanName("springSecurityFilterChain");

        FilterRegistrationBean<DelegatingFilterProxy> registrationBean
          = new FilterRegistrationBean<>();

        registrationBean.setFilter(delegatingFilterProxy);
        return registrationBean;
    }
}