import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Temp591Application {
    public static void main(String[] args) {
        SpringApplication.run(Temp591Application.class, args);
    }
}

@RestController
class Temp591Controller {

    @Secured("arn:aws:iam::xxxxxx:role/spring-sso-test-ADMIN")
    @GetMapping(produces = "application/json")
    public TestResponse get() {
        return new TestResponse("Admin API Response");
    }
}

class TestResponse {
    private String message;

    public TestResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}