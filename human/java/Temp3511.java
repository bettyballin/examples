import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import javax.servlet.Filter;

@SpringBootApplication
public class Temp3511 {

    @Autowired
    XHeaderAuthenticationFilter xHeaderAuthenticationFilter;

    public static void main(String[] args) {
        SpringApplication.run(Temp3511.class, args);
    }

    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(xHeaderAuthenticationFilter);
        return registrationBean;
    }
}

class XHeaderAuthenticationFilter implements Filter {
    // Implement the necessary methods for the filter
}