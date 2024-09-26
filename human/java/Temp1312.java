import javax.servlet.Filter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Temp1312 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1312.class, args);
    }

    @Bean
    public FilterRegistrationBean<Filter> springSecurityFilterChainRegistrationBean(@Qualifier("springSecurityFilterChain") Filter filter) {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(filter);
        bean.setEnabled(false);
        return bean;
    }
}