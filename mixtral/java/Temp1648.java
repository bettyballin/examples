import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Temp1648 {
    private static final Logger log = LoggerFactory.getLogger(Temp1648.class);

    public static void main(String[] args) {
        // Main method can be used to test other parts of the code, if needed.
    }

    @DeleteMapping("/api/shoes/{id}")
    public void delete(@PathVariable("id") Long shoeId) {
        log.error("handle delete");
        // Additional logic for deleting a shoe can be added here
    }
}