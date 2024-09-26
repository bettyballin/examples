import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp828Application {
    public static void main(String[] args) {
        SpringApplication.run(Temp828Application.class, args);
    }
}

@RestController
public class Temp828Controller {

    @RequestMapping(value = "/url", method = RequestMethod.GET, headers = {"my-header"})
    public String handleRequest(@RequestHeader("my-header") String header) {
        return "Header value: " + header;
    }
}