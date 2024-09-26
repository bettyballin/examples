import javax.servlet.Filter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@SpringBootApplication
public class Temp1899 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1899.class, args);
    }

    @Bean
    public FilterRegistrationBean<Filter> registration(@Qualifier("customFilter") Filter filter) {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>(filter);
        registration.setEnabled(false);
        return registration;
    }
}