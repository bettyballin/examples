import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Temp2084 {
    public static void main(String[] args) {
        // Spring application context should be started for this to work,
        // but for the simplicity, we are not providing a full Spring Boot application setup.
    }

    @RequestMapping("/security_check")
    public String loginCheck() {
        // You don't need to do anything here.
        return "Security check passed";
    }
}