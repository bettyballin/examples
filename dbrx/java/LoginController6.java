import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MySpringBootApplication implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // registry.addViewController("/login").setViewName("my-login-page"); 
        // Removed this line to avoid conflict with LoginController
    }
}

@Controller
class LoginController {

    @GetMapping("/login")
    public String login() {
        return "my-login-page";
    }
}