import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Temp266 {

    @Secured({"ROLE_SPECIAL_USER"})
    @RequestMapping("/somespecial")
    @ResponseBody
    public String specialEndpoint() {
        return "Access granted to ROLE_SPECIAL_USER";
    }

    public static void main(String[] args) {
        // Spring Boot application should be started here
        org.springframework.boot.SpringApplication.run(Temp266.class, args);
    }
}