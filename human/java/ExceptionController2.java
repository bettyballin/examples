import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

// Add appropriate import statements for logger and exception handling
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestController
@ControllerAdvice
public class ExceptionController implements ErrorController {
    private static final Logger log = LoggerFactory.getLogger(ExceptionController.class);

    // @ExceptionHandler methods here.
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        log.error("Exception caught: ", e);
        return "An error occurred: " + e.getMessage();
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}