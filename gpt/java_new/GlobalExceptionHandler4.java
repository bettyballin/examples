import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.security.core.AuthenticationException;

@ControllerAdvice
public class GlobalExceptionHandler4 {

   @ExceptionHandler(AuthenticationException.class)
   public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
       return ResponseEntity
               .status(HttpStatus.BAD_REQUEST)
               .body("Invalid username or password");
   }
}