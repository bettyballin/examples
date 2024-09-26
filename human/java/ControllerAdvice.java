import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.hateoas.VndErrors;

// Custom exception class
class PersonNotFoundException extends RuntimeException {
    private final Long id;

    public PersonNotFoundException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<VndErrors> notFoundException(final PersonNotFoundException e) {
        VndErrors error = new VndErrors("error", "Person with id " + e.getId() + " not found");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}