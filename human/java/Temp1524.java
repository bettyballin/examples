import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp1524 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1524.class, args);
    }
}

@RestController
class TestController {

    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String download(@PathVariable("id") String id) {
        // Implement the logic for the download process
        return "Downloaded content with ID: " + id;
    }
}