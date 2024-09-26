import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SpringBootApplication
public class Temp304 {
    public static void main(String[] args) {
        SpringApplication.run(Temp304.class, args);
    }
}

@RestController
class MyController {

    @GetMapping("/test/{id}")
    @IpRestricted("192.168.1.1")
    public String download(@PathVariable("id") String id) {
        // Your logic here
        return "Downloaded: " + id;
    }
}

// Custom annotation for IP restriction (dummy implementation)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface IpRestricted {
    String value();
}