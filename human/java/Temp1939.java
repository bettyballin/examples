import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import javax.servlet.Filter;

@SpringBootApplication
public class Temp1939 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1939.class, args);
    }

    @Bean
    public FilterRegistrationBean<Filter> registration(MyFilter filter) {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>(filter);
        registration.setEnabled(false);
        return registration;
    }

    @Bean
    public MyFilter myFilter() {
        return new MyFilter();
    }
}

class MyFilter implements Filter {
    // Implement Filter methods here
}