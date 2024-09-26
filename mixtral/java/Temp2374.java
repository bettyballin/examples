import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Temp2374 {

    @Secured("ROLE_arn:aws:iam::xxxxxx:role/spring-sso-test-ADMIN")
    @GetMapping(produces = "application/json")
    public TestResponse get() {
        return new TestResponse("Admin API Response");
    }

    public static void main(String[] args) {
        // Spring Boot application setup would typically go here
    }

    static class TestResponse {
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
}