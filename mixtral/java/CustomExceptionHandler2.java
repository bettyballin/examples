import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(CustomAccessDeniedException.class)
  public final ResponseEntity<Object> handleUserNotFoundException(
      CustomAccessDeniedException ex, WebRequest request) {
    ExceptionResponse exceptionResponse = new ExceptionResponse();

    // set status code and message
    exceptionResponse.setMessage(ex.getMessage());
    exceptionResponse.setStatus(HttpStatus.FORBIDDEN.value());

    return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);
  }
}

class CustomAccessDeniedException extends RuntimeException {
  public CustomAccessDeniedException(String message) {
    super(message);
  }
}

class ExceptionResponse {
  private int status;
  private String message;

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}