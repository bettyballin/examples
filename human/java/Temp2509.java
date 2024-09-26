import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class Temp2509 {
    private static final Logger log = LoggerFactory.getLogger(Temp2509.class);

    public static void main(String[] args) {
        // This is a Spring Boot application, main method is not used in this context.
        // Application should be run as a Spring Boot application.
    }

    @DeleteMapping("/shoes/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long shoeId) {
        log.error("handle delete");
        return ResponseEntity.ok().build();
    }
}