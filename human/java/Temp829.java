import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp829 {
    public static void main(String[] args) {
        SpringApplication.run(Temp829.class, args);
    }
}

@RestController
class MyController {
    @RequestMapping(value = "/something", headers = "content-type=text")
    public String handleRequest() {
        return "Handled request with content-type=text";
    }
}