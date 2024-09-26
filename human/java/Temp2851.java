import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.springboot.reserving.member")
public class Temp2851 {
    public static void main(String[] args) {
        SpringApplication.run(Temp2851.class, args);
    }
}