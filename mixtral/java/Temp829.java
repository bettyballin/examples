import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
public class Temp829Application {
    public static void main(String[] args) {
        SpringApplication.run(Temp829Application.class, args);
    }
}

@RestController
class Temp829Controller {

    @GetMapping("/query")
    public ResponseEntity<String> query(HttpServletRequest request) {
        String sessionId = request.getSession().getId();

        // Your logic here

        return ResponseEntity.ok("Session ID: " + sessionId);
    }
}


To run this code, you need to have Spring Boot set up in your project. You can create a Spring Boot project using Spring Initializr or your preferred method.