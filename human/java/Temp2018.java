import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SpringBootApplication
public class Temp2018Application {
    public static void main(String[] args) {
        SpringApplication.run(Temp2018Application.class, args);
    }
}

@RestController
@RequestMapping("/api")
class Temp2018Controller {

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/is_auth")
    public void ping() {
        // log ?
    }
}


To execute this code, ensure you have the necessary Spring Boot dependencies in your `pom.xml` for Maven or `build.gradle` for Gradle.