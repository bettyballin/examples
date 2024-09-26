import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController1 {

    @PostMapping("/")
    public String handlePostRequest() {
        return "Handling POST request";
    }
}