import org.springframework.boot.autoconfigure.SpringBootApplication3;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;

@SpringBootApplication3(exclude = RepositoryRestMvcAutoConfiguration.class)
public class Application3 {
    public static void main(String[] args) {
        // Your application logic here
    }
}