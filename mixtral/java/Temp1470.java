import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AccessDeniedByRoleException.class)
    public ResponseEntity<String> accessDeniedForRoles(AccessDeniedByRoleException e) {
        return ResponseEntity
            .status(HttpStatus.FORBIDDEN).body("You are not authorized to perform this action.");
    }
}

class AccessDeniedByRoleException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AccessDeniedByRoleException(String message) {
        super(message);
    }
}