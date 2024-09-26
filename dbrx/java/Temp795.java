import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Temp795 {
    public static void main(String[] args) {
        SpringApplication.run(Temp795.class, args);
    }

    @RequestMapping("/csrf")
    public String getCsrf() {
        return "redirect:/";
    }
}