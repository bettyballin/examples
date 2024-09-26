import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpSession;
import java.util.Map;

@SpringBootApplication
public class Temp1656 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1656.class, args);
    }
}

@RestController
class LoginController {

    @PostMapping(value = "/validateLogin")
    public ResponseEntity<String> validateLogin(@RequestBody Map<String, String> user, HttpSession session) {
        // Login validation logic here
        return ResponseEntity.ok("Login validated");
    }
}