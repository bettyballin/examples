import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(UserStatusException.class)
    public ResponseEntity<String> handleUserStatusException(UserStatusException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<String> handleUsernameNotFoundException(UsernameNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

class UserStatusException extends RuntimeException {
    public UserStatusException(String message) {
        super(message);
    }
}

@RestController
@RequestMapping("/test")
class TestController {
    
    @GetMapping("/userStatusException")
    public String triggerUserStatusException() {
        throw new UserStatusException("User status exception occurred");
    }

    @GetMapping("/usernameNotFoundException")
    public String triggerUsernameNotFoundException() {
        throw new UsernameNotFoundException("Username not found exception occurred");
    }
}

// Main Application
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}