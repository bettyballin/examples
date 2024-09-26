import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.SpringApplication;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class Temp3046 {
    public static void main(String[] args) {
        SpringApplication.run(Temp3046.class, args);
    }
}