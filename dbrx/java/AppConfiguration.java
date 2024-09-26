import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@SpringBootApplication
public class AppConfiguration implements WebMvcConfigurer {

    @Bean
    public MyErrorHandler myErrorHandler() {
        return new MyErrorHandler();
    }

    public static void main(String[] args) {
        SpringApplication.run(AppConfiguration.class, args);
    }
}

class MyErrorHandler {
    // Implementation of MyErrorHandler
}