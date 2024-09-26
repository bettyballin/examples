import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Temp463Application {
    public static void main(String[] args) {
        SpringApplication.run(Temp463Application.class, args);
    }

    @RequestMapping("/image/{id}")
    public String getArticleImageUrl(@PathVariable String id) {
        // Implementation of your logic here. For demonstration, we return id.
        return "Image URL for ID: " + id;
    }
}