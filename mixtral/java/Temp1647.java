import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Temp1647 {
    private static final Logger log = LoggerFactory.getLogger(Temp1647.class);

    public static void main(String[] args) {
        // This is a placeholder for the main method. 
        // In a real Spring Boot application, you would start the Spring context here.
    }

    @DeleteMapping("/shoes/{id}")
    public void delete(@PathVariable("id") Long shoeId) {
        log.error("handle delete");
    }
}