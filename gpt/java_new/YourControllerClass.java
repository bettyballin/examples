import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class YourControllerClass {

    // Assuming logger is defined elsewhere in your class
    // private static final Logger logger = LoggerFactory.getLogger(YourControllerClass.class);

    @DeleteMapping("/rest/motivos/{id}")
    public void deleteMotivo(@PathVariable(name="id") String id) {
        // logger.debug("Eliminando el motivo " + id);
    }
}