import org.springframework.data.jpa.repository.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Temp3675 {

    public static void main(String[] args) {
        SpringApplication.run(Temp3675.class, args);
    }

    @Bean
    public String exampleBean() {
        return "Hello, Spring Boot!";
    }
}