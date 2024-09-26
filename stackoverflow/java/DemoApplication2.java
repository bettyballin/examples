import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.microsoft.azure.spring.autoconfigure.aad.AADAutoConfiguration;

@SpringBootApplication(exclude = {AADAutoConfiguration.class})
public class DemoApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication2.class, args);
    }
}