import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Temp835 {
    public static void main(String[] args) {
        try {
            // Load User entity from DB using username/email/etc...
        } catch (Exception e) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}