import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.hateoas.VndErrors;

@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

   @ExceptionHandler(PersonNotFoundException.class) 
   public ResponseEntity<VndErrors> notFoundException(final PersonNotFoundException e) {
      return error(e, HttpStatus.NOT_FOUND, e.getId().toString());
   }

   private ResponseEntity<VndErrors> error(final Exception exception, final HttpStatus httpStatus, final String logRef) {
      final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
      return new ResponseEntity<>(new VndErrors(logRef, message), httpStatus);
   }
   
   // Assuming PersonNotFoundException is defined somewhere else in the codebase
   public static class PersonNotFoundException extends Exception {
       private Long id;

       public PersonNotFoundException(Long id) {
           super("Person not found with ID: " + id);
           this.id = id;
       }

       public Long getId() {
           return id;
       }
   }
}