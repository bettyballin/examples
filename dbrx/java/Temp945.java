import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Temp945 {
    public static void main(String[] args) {
        SpringApplication.run(Temp945.class, args);
    }

    @RequestMapping("/test2")
    public ResponseEntity<String> handleErrors(HttpServletRequest request) {
        Throwable ex = (Throwable) request.getAttribute("javax.servlet.error.exception");

        if (ex instanceof Custom403Exception) {
            // Handle 403 error with custom message or data from the exception.
            return ResponseEntity.status(403).body("Custom 403 error message");
        } else if (ex instanceof Custom404Exception) {
            // Handle 404 error with custom message or data from the exception.
            return ResponseEntity.status(404).body("Custom 404 error message");
        }

        return ResponseEntity.status(500).body("Unknown error");
    }
}

// Custom exception classes
class Custom403Exception extends RuntimeException {
}

class Custom404Exception extends RuntimeException {
}