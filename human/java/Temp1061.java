import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class Temp1061Application {
    public static void main(String[] args) {
        SpringApplication.run(Temp1061Application.class, args);
    }
}

@Controller
class Temp1061Controller {
    @RequestMapping("/403")
    public String accessDenied() {
        return "errors/403";
    }
}