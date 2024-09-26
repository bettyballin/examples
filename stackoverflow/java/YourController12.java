import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

public class YourController12 {

    @ExceptionHandler(CustomAuthenticationException.class)
    public ResponseEntity<Object> handleBadCredentialsException(CustomAuthenticationException exception) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, LocalDateTime.now(), exception.getMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    // Assume ErrorResponse class is defined elsewhere with the appropriate constructor
    // Assume CustomAuthenticationException class is defined elsewhere
}