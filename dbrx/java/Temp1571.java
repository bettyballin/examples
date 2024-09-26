import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Temp1571 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1571.class, args);
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> {
            // Custom initialization code here
            System.out.println("Custom ServletContextInitializer is called.");
        };
    }
}