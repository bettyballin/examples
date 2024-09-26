import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SecurityExceptionHandlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityExceptionHandlerApplication.class, args);
    }

    @ControllerAdvice
    public static class SecurityExceptionHandler {

        @ResponseBody
        @ExceptionHandler(AuthenticationException.class)
        public String handleAuthenticationException(AuthenticationException e) {
            return "{\"error\": \"Invalid credentials\"}";
        }

        @ResponseBody
        @ExceptionHandler(AccessDeniedException.class)
        public String handleAccessDeniedException(AccessDeniedException e) {
            return "{\"error\": \"Access denied\"}";
        }
    }

    @RestController
    public static class TestController {
        @GetMapping("/auth")
        public String authTest() {
            throw new AuthenticationException("Test Authentication Exception") {};
        }

        @GetMapping("/access")
        public String accessTest() {
            throw new AccessDeniedException("Test Access Denied Exception");
        }
    }
}