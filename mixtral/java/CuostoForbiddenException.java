import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.servlet.NoHandlerFoundException;

public class CustomForbiddenException extends RuntimeException {

  public CustomForbiddenException(String message, Throwable cause){
    super(message, cause);
  }
}

@Component
@ControllerAdvice
class GlobalErrorHandler extends ResponseEntityExceptionHandler {

   @Override
   protected ResponseEntity<Object> handleHttpMessageNotReadable(
      HttpMessageNotReadableException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {

     return buildResponseBody("Malformed JSON Request",
        "Please verify the syntax of your provided input.",
        400);
   }

  @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        return buildResponseBody("Validation Error",
                "Please verify the provided input.",
                400);
    }

   @Override
   protected ResponseEntity<Object> handleNoHandlerFoundException(
      NoHandlerFoundException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {

     return buildResponseBody("No Handler Found",
        "The requested URL was not found on this server.",
        404);
   }

   private ResponseEntity<Object> buildResponseBody(String error, String message, int status) {
       return new ResponseEntity<>(new ErrorResponse(error, message), HttpStatus.valueOf(status));
   }

   class ErrorResponse {
       private String error;
       private String message;

       public ErrorResponse(String error, String message) {
           this.error = error;
           this.message = message;
       }

       public String getError() {
           return error;
       }

       public String getMessage() {
           return message;
       }
   }
}