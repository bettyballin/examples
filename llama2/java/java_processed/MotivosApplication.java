import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MotivosApplication {
    public static void main(String[] args) {
        SpringApplication.run(MotivosApplication.class, args);
    }
}

@RestController
class MotivosController {

    @GetMapping("/template")
    public String getTemplate() {
        return "template";
    }

    @DeleteMapping("/delete")
    public void deleteSomething() {
        // delete logic
    }
}