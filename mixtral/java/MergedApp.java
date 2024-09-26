import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MergedApp {
    public static void main(String[] args) {
        SpringApplication.run(MergedApp.class, args);
    }
}

@Controller
public class UiAndMvcController implements WebMvcConfigurer {
    @RequestMapping("/")
    public String home() {
        return "home";
    }
}