import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(UserNotConfirmedAndTimeExceeded.class)
    public ResponseEntity<String> handleUserNotConfirmedAndTimeExceeded(UserNotConfirmedAndTimeExceeded ex) {
        // Assuming an error message and a HttpStatus are needed
        String errorMessage = "User confirmation time has exceeded.";
        return new ResponseEntity<>(errorMessage, HttpStatus.REQUEST_TIMEOUT);
    }
}