import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Temp1467 {
    @RequestMapping(value = "/external")
    public String externalAuth() {
        boolean someCondition = true; // Replace with actual condition
        String someExternalUrl = "https://external-service.com"; // Replace with actual URL
        if (someCondition) {
            return "redirect:" + someExternalUrl;
        } else {
            return "redirect:/";
        }
    }

    public static void main(String[] args) {
        // Spring Boot application entry point
        org.springframework.boot.SpringApplication.run(Temp1467.class, args);
    }
}