import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

// Dummy Win32Exception class
class Win32Exception extends RuntimeException {
    public Win32Exception(String message) {
        super(message);
    }
}

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Win32Exception.class)
    @ResponseStatus(HttpStatus.FORBIDDEN) // Set appropriate HTTP status
    public String handleWin32Excepiton() {
        return "access-denied";
    }
}