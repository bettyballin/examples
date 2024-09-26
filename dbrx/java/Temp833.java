import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Temp833 {
    public static void main(String[] args) {
        ResponseEntity<String> responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect current password.");
        System.out.println(responseEntity);
    }
}